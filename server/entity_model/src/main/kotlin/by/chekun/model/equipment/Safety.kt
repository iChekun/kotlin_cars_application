package by.chekun.model.equipment

import by.chekun.model.AbstractEntity
import by.chekun.model.Car
import javax.persistence.*


@Entity
@Table(name = "safeties")
class Safety : AbstractEntity {

    @Column(name = "safety", nullable = false, unique = true)
    lateinit var safety: String

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "car_safeties",
        joinColumns = [JoinColumn(name = "safety_id")],
        inverseJoinColumns = [JoinColumn(name = "car_id")]
    )
     var carSafeties: MutableList<Car> = ArrayList()


    constructor()

    constructor(id: Long, safety: String) : super(id) {
        this.safety = safety
    }


}