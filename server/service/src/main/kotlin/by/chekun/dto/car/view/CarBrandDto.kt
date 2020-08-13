package by.chekun.dto.car.view

import by.chekun.dto.AbstractDto

class CarBrandDto : AbstractDto {

    lateinit var title: String

    constructor()

    constructor(id: Long, title: String) : super(id) {
        this.title = title
    }
}