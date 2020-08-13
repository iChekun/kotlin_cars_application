package by.chekun.dto.car.brand

import by.chekun.dto.AbstractDto
import java.util.*


class ReleaseYearDto : AbstractDto {

    var releaseYear: Int = 0

    var generations: Set<GenerationDto> = HashSet()

    constructor()

    constructor(id: Long, releaseYear: Int, generations: Set<GenerationDto>) : super(id) {
        this.releaseYear = releaseYear
        this.generations = generations
    }


}