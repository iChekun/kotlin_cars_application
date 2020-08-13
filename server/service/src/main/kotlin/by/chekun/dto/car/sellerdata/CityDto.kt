package by.chekun.dto.car.sellerdata

import by.chekun.dto.AbstractDto


class CityDto : AbstractDto {

    lateinit var name: String

    constructor()

    constructor(id: Long, name: String) : super(id) {
        this.name = name
    }

}




