package by.chekun.dto.car.view

import by.chekun.dto.AbstractDto

class CarModelDto : AbstractDto {

    lateinit var name: String

    constructor()

    constructor(id: Long, name: String) : super(id) {
        this.name = name
    }

}