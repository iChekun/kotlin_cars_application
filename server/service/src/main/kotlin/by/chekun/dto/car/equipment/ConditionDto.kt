package by.chekun.dto.car.equipment

import by.chekun.dto.AbstractDto


class ConditionDto : AbstractDto {

    lateinit var value: String

    constructor()

    constructor(id: Long, value: String) : super(id) {
        this.value = value
    }

}