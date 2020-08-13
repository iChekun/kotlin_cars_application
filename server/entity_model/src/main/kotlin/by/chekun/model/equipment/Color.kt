package by.chekun.model.equipment

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "colors")
class Color : AbstractEntity {

    @Column(name = "color", nullable = false, unique = true)
    lateinit var color: String


    constructor()

    constructor(id: Long, color: String) : super(id) {
        this.color = color
    }


}