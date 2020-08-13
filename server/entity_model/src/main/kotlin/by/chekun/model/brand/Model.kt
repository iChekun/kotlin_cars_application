package by.chekun.model.brand

import by.chekun.model.AbstractEntity
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "models")
class Model : AbstractEntity {

    @Column(name = "name", unique = true, nullable = false)
    lateinit var name: String

    @ManyToMany(mappedBy = "modelReleaseYear", fetch = FetchType.LAZY)
    var releaseYears: Set<ReleaseYear> = HashSet()


    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "brand_models",
        joinColumns = [JoinColumn(name = "model_id")],
        inverseJoinColumns = [JoinColumn(name = "brand_id")]
    )
    var brandModels: List<Model> = ArrayList()


    constructor()

    constructor(id: Long, name: String) : super(id) {
        this.name = name
    }


}