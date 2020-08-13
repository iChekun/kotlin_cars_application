package by.chekun.model.sellerdata

import by.chekun.model.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "cities")
class City : AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    lateinit var name: String

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "region_cities",
        joinColumns = [JoinColumn(name = "city_id")],
        inverseJoinColumns = [JoinColumn(name = "region_id")]
    )
     var regionCities: List<Region> = ArrayList()

    constructor()

    constructor(id: Long, name: String) : super(id) {
        this.name = name
    }


}




