package by.chekun.dto.car.brand

import by.chekun.dto.AbstractDto
import java.util.*


class GenerationDto : AbstractDto {

    lateinit var generation: String

    var startYear: Int = 0

    var finishYear: Int = 0

    var bodyTypes: Set<BodyTypeDto> = HashSet()

    // var releaseYearDtoGenerations: List<ReleaseYearDto> = ArrayList()


    constructor()

    constructor(
        id: Long,
        generation: String,
        bodyTypes: Set<BodyTypeDto>
    ) : super(id) {
        this.generation = generation
        this.bodyTypes = bodyTypes
    }


}