package by.chekun.repository.database.entity.car.chassis


import by.chekun.repository.database.entity.AbstractDto


class TransmissionTypeDto : AbstractDto {

    lateinit var transmissionType: String

    constructor()

    constructor(id: Long, transmissionType: String) : super(id) {
        this.transmissionType = transmissionType
    }


}

