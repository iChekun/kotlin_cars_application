package by.chekun.model.brand

import by.chekun.model.AbstractEntity
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "release_years")
class ReleaseYear : AbstractEntity {

    @Column(name = "release_year", nullable = false, unique = true)
    var releaseYear: Int = 0


    @ManyToMany(mappedBy = "releaseYearGenerations", fetch = FetchType.LAZY)
    var generations: Set<Generation> = HashSet()


    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "model_release_years",
        joinColumns = [JoinColumn(name = "release_year_id")],
        inverseJoinColumns = [JoinColumn(name = "model_id")]
    )
    var modelReleaseYear: List<Model> = ArrayList()


    constructor()

    constructor(id: Long, releaseYear: Int, generations: Set<Generation>) : super(id) {
        this.releaseYear = releaseYear
        this.generations = generations
    }


}