package by.chekun.dto.car.chassis

import by.chekun.dto.AbstractDto


class EngineTypeDto : AbstractDto {

    lateinit var engineType: String

    constructor()

    constructor(id: Long, engineType: String) : super(id) {
        this.engineType = engineType
    }

}