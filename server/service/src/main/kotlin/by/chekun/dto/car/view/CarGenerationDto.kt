package by.chekun.dto.car.view

import by.chekun.dto.AbstractDto

class CarGenerationDto : AbstractDto {

    lateinit var generation: String

    var startYear: Int = 0

    var finishYear: Int = 0

    constructor()

    constructor(
        id: Long,
        generation: String
    ) : super(id) {
        this.generation = generation
    }

}