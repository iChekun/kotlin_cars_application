package by.chekun.dto.car.interior

import by.chekun.dto.AbstractDto


class InteriorColorDto : AbstractDto {

    lateinit var interiorColor: String

    constructor()

    constructor(id: Long, interiorColor: String) : super(id) {
        this.interiorColor = interiorColor
    }

}