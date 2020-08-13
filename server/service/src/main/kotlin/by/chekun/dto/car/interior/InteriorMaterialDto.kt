package by.chekun.dto.car.interior

import by.chekun.dto.AbstractDto


class InteriorMaterialDto : AbstractDto {

    lateinit var interiorMaterial: String

    constructor()

    constructor(id: Long, interiorMaterial: String) : super(id) {
        this.interiorMaterial = interiorMaterial
    }

}
