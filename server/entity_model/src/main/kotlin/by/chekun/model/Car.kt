package by.chekun.model

import javax.persistence.*

@Entity
@Table(name = "cars")
class Car() : AbstractEntity() {

    @Column(name = "title", nullable = false)
    lateinit var model: String


    @Column(name = "generation", nullable = false)
    lateinit var generation: String

    @Column(name = "mileage")
    var mileage: Double = 0.0

    @Column(name = "body_type")
    lateinit var bodyType: String

    @Column(name = "transmission_type")
    lateinit var transmissionType: String

    @Column(name = "fuel_type")
    lateinit var fuelType: String

    @Column(name = "wheel_drive_type")
    lateinit var wheelDriveType: String

    @Column(name = "engine_capacity")
    var engineCapacity: Double = 0.0


    @Column(name = "release_year")
    var releaseYear: Int = 0

    @Column(name = "price")
    var price: Double = 0.0

    @Column(name = "description", length = 512)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var brand: Brand

    @Lob
    @Column(name = "picture")
    lateinit var picture: ByteArray

}
