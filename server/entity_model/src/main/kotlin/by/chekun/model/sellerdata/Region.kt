package by.chekun.model.sellerdata

import by.chekun.model.AbstractEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "regions")
class Region : AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    lateinit var name: String

    @ManyToMany(mappedBy = "regionCities", fetch = FetchType.LAZY)
     var cities: Set<City> = HashSet()

    constructor()

    constructor(id: Long, name: String) : super(id) {
        this.name = name
    }


}
