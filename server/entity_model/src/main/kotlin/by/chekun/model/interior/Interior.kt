package by.chekun.model.interior

import by.chekun.model.AbstractEntity
import by.chekun.model.Car
import javax.persistence.*


@Entity
@Table(name = "interior")
class Interior : AbstractEntity {

    @Column(name = "interior", nullable = false, unique = true)
    lateinit var interior: String


    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "car_interior",
        joinColumns = [JoinColumn(name = "interior_id")],
        inverseJoinColumns = [JoinColumn(name = "car_id")]
    )
     var carInterior: List<Car> = ArrayList()


    constructor()

    constructor(id: Long, interior: String) : super(id) {
        this.interior = interior
    }


}

