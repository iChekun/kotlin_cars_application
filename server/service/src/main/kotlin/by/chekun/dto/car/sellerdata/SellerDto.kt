package by.chekun.dto.car.sellerdata

import by.chekun.dto.AbstractDto


class SellerDto : AbstractDto {

    lateinit var regionDto: RegionDto

    lateinit var name: String

    lateinit var phoneNumber: String

    constructor()


    constructor(id: Long, regionDto: RegionDto, name: String, phoneNumber: String) : super(id) {
        this.regionDto = regionDto
        this.name = name
        this.phoneNumber = phoneNumber
    }

}

