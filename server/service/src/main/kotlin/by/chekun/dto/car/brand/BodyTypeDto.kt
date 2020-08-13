package by.chekun.dto.car.brand

import by.chekun.dto.AbstractDto


class BodyTypeDto : AbstractDto {

    lateinit var bodyType: String

    constructor()

    constructor(
        id: Long,
        bodyType: String
    ) : super(id) {
        this.bodyType = bodyType
    }
}