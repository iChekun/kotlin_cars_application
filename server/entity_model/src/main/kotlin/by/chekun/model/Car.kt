package by.chekun.model

import by.chekun.model.brand.*
import by.chekun.model.chassis.EngineType
import by.chekun.model.chassis.TransmissionType
import by.chekun.model.chassis.WheelDriveType
import by.chekun.model.equipment.Color
import by.chekun.model.equipment.Condition
import by.chekun.model.equipment.Safety
import by.chekun.model.interior.Interior
import by.chekun.model.interior.InteriorColor
import by.chekun.model.interior.InteriorMaterial
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "cars")
class Car : AbstractEntity() {

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var brand: Brand

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var model: Model

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var releaseYear: ReleaseYear

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var generation: Generation

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var bodyType: BodyType

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var color: Color

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var condition: Condition

    @Embedded
    lateinit var mileage: Mileage

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var interiorColor: InteriorColor

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var interiorMaterial: InteriorMaterial

    @ManyToMany(mappedBy = "carSafeties", fetch = FetchType.EAGER)
    var safeties: MutableSet<Safety> = HashSet()

    @ManyToMany(mappedBy = "carInterior", fetch = FetchType.EAGER)
    var interior: MutableSet<Interior> = HashSet()

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var engineType: EngineType

    @Column(name = "engine_capacity")
    var engineCapacity: Double = 0.0

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var transmissionType: TransmissionType

    @ManyToOne(fetch = FetchType.EAGER)
    lateinit var wheelDriveType: WheelDriveType

    @Column(name = "price")
    var price: Double = 0.0

    @Column(name = "description", length = 512)
    lateinit var description: String

    @Lob
    @Column(name = "picture")
    var picture: ByteArray? = null


    @Column(name = "WIN", length = 21)
    lateinit var win: String

    @Column(name = "date_of_creation", nullable = false)
    var dateOfCreation: LocalDateTime? = null

    @Column(name = "date_of_modification", nullable = false)
    var dateOfModification: LocalDateTime? = null

    @PrePersist
    private fun onCreate() {
        dateOfCreation = LocalDateTime.now()
        dateOfModification = LocalDateTime.now()
    }

    @PreUpdate
    private fun onUpdate() {
        dateOfModification = LocalDateTime.now()
    }

}
