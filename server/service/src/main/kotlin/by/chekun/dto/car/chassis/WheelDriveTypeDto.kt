package by.chekun.dto.car.chassis

import by.chekun.dto.AbstractDto


class WheelDriveTypeDto : AbstractDto {

    lateinit var wheelDriveType: String

    constructor()

    constructor(id: Long, wheelDriveType: String) : super(id) {
        this.wheelDriveType = wheelDriveType
    }

}

