package by.chekun.model.chassis

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "engine_types")
class EngineType : AbstractEntity {

    @Column(name = "engine_type", nullable = false, unique = true)
    lateinit var engineType: String


    constructor()

    constructor(id: Long, engineType: String) : super(id) {
        this.engineType = engineType
    }


}