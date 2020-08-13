package by.chekun.dto.car.equipment

import by.chekun.dto.AbstractDto


class ColorDto : AbstractDto {

    lateinit var color: String

    constructor()

    constructor(id: Long, color: String) : super(id) {
        this.color = color
    }

}