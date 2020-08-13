package by.chekun.model.brand

import by.chekun.model.AbstractEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "brands")
class Brand : AbstractEntity {

    @Column(name = "title", unique = true, nullable = false)
    lateinit var title: String

    @ManyToMany(mappedBy = "brandModels", fetch = FetchType.LAZY)
    var models: Set<Model> = HashSet()


    constructor()

    constructor(id: Long, title: String) : super(id) {
        this.title = title
    }

}

