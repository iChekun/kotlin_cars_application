package by.chekun.dto.car.chassis

import by.chekun.dto.AbstractDto


class TransmissionTypeDto : AbstractDto {

    lateinit var transmissionType: String

    constructor()

    constructor(id: Long, transmissionType: String) : super(id) {
        this.transmissionType = transmissionType
    }


}

