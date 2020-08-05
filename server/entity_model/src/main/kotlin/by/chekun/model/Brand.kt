package by.chekun.model

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "brands")
class Brand : AbstractEntity {

    @Column(name = "title", unique = true, nullable = false)
    lateinit var title: String

    @OneToMany(
        cascade = [
            CascadeType.MERGE,
            CascadeType.PERSIST
        ],
        fetch = FetchType.LAZY,
        mappedBy = "brand"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    lateinit var cars: Set<Car>

    constructor()

    constructor(id: Long, title: String) : super(id) {
        this.title = title
    }

    constructor(id: Long, title: String, cars: Set<Car>) : super(id) {
        this.title = title
        this.cars = cars
    }

}

