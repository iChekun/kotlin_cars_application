package by.chekun.dto.car.brand

import by.chekun.dto.AbstractDto
import java.util.*


class BrandDto : AbstractDto {

    lateinit var title: String

    var models: Set<ModelDto> = HashSet()

    constructor()

    constructor(id: Long, title: String) : super(id) {
        this.title = title
    }

}

