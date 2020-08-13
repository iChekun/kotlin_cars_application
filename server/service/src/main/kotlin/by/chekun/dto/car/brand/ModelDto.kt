package by.chekun.dto.car.brand

import by.chekun.dto.AbstractDto
import java.util.*

class ModelDto : AbstractDto {


    lateinit var name: String


    var releaseYears: Set<ReleaseYearDto> = HashSet()


    constructor()

    constructor(id: Long, name: String) : super(id) {
        this.name = name
    }

}