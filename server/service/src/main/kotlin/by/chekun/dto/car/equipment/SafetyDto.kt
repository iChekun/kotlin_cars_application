package by.chekun.dto.car.equipment

import by.chekun.dto.AbstractDto
import by.chekun.model.Car


class SafetyDto : AbstractDto {

    lateinit var safety: String

    constructor()

    constructor(id: Long, safety: String) : super(id) {
        this.safety = safety
    }

}