package by.chekun.model.brand

import by.chekun.model.AbstractEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "generations")
class Generation : AbstractEntity {

    @Column(name = "generation", nullable = false)
    lateinit var generation: String

    @Column(name = "start_year", nullable = false)
    var startYear: Int = 0

    @Column(name = "finish_year", nullable = false)
    var finishYear: Int = 0

    @ManyToMany(mappedBy = "bodyTypeGenerations", fetch = FetchType.LAZY)
    var bodyTypes: Set<BodyType> = HashSet()


    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "release_year_generation",
        joinColumns = [JoinColumn(name = "generation_id")],
        inverseJoinColumns = [JoinColumn(name = "release_year_id")]
    )
    var releaseYearGenerations: List<ReleaseYear> = ArrayList()


    constructor()

    constructor(
        id: Long,
        generation: String,
        bodyTypes: Set<BodyType>,
        releaseYearGenerations: List<ReleaseYear>
    ) : super(id) {
        this.generation = generation
        this.bodyTypes = bodyTypes
        this.releaseYearGenerations = releaseYearGenerations
    }


}