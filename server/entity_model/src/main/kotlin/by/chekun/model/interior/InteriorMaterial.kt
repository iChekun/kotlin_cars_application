package by.chekun.model.interior

import by.chekun.model.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table(name = "interior_materials")
class InteriorMaterial : AbstractEntity {

    @Column(name = "interior_material", nullable = false, unique = true)
    lateinit var interiorMaterial: String


    constructor()

    constructor(id: Long, interiorMaterial: String) : super(id) {
        this.interiorMaterial = interiorMaterial
    }


}
