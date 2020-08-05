package by.chekun.dto

import javax.validation.constraints.NotBlank


class BrandDto : AbstractDto {

    @field: NotBlank(message = "Brand title is required!")
    lateinit var title: String

    constructor()

    constructor(id: Long, title: String) : super(id) {
        this.title = title
    }

}