package by.chekun.repository.database.entity.car.chassis

import by.chekun.repository.database.entity.AbstractDto


class EngineTypeDto : AbstractDto {

    lateinit var engineType: String

    constructor()

    constructor(id: Long, engineType: String) : super(id) {
        this.engineType = engineType
    }

}