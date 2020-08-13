package by.chekun.model.brand

import by.chekun.model.AbstractEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "body_types")
class BodyType : AbstractEntity {

    @Column(name = "body_type")
    lateinit var bodyType: String

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "body_type_generations",
        joinColumns = [JoinColumn(name = "body_type_id")],
        inverseJoinColumns = [JoinColumn(name = "generation_id")]
    )
    var bodyTypeGenerations: List<Generation> = ArrayList()


    constructor()

    constructor(
        id: Long,
        bodyType: String,
        bodyTypeGenerations: List<Generation>
    ) : super(id) {
        this.bodyType = bodyType
        this.bodyTypeGenerations = bodyTypeGenerations
    }
}