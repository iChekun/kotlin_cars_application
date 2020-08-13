package by.chekun.repository.database.entity.car.chassis

import by.chekun.repository.database.entity.AbstractDto


class WheelDriveTypeDto : AbstractDto {

    lateinit var wheelDriveType: String

    constructor()

    constructor(id: Long, wheelDriveType: String) : super(id) {
        this.wheelDriveType = wheelDriveType
    }

}

