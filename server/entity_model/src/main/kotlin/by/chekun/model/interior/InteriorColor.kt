package by.chekun.model.interior

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "interior_colors")
class InteriorColor : AbstractEntity {

    @Column(name = "interior_color", nullable = false, unique = true)
    lateinit var interiorColor: String


    constructor()

    constructor(id: Long, interiorColor: String) : super(id) {
        this.interiorColor = interiorColor
    }


}