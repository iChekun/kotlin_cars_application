package by.chekun.dto.car.interior

import by.chekun.dto.AbstractDto
import by.chekun.model.Car


class InteriorDto : AbstractDto {

    lateinit var interior: String

    constructor()

    constructor(id: Long, interior: String) : super(id) {
        this.interior = interior
    }

}

