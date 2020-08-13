package by.chekun.dto.car.view

import by.chekun.dto.AbstractDto

class CarReleaseYearDto : AbstractDto {

    var releaseYear: Int = 0

    constructor()

    constructor(id: Long, releaseYear: Int) : super(id) {
        this.releaseYear = releaseYear
    }
}