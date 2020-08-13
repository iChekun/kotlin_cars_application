package by.chekun.model.equipment

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "conditions")
class Condition : AbstractEntity {

    @Column(name = "value", nullable = false, unique = true)
    lateinit var value: String


    constructor()

    constructor(id: Long, value: String) : super(id) {
        this.value = value
    }


}

