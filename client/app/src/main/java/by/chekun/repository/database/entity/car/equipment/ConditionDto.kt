package by.chekun.repository.database.entity.car.equipment

import by.chekun.repository.database.entity.AbstractDto


class ConditionDto : AbstractDto {

    lateinit var value: String

    constructor()

    constructor(id: Long, value: String) : super(id) {
        this.value = value
    }

}