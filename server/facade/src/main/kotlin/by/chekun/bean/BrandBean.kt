package by.chekun.bean

import javax.validation.constraints.NotBlank


class BrandBean : AbstractBean {

    @field: NotBlank(message = "Title is required!")
    lateinit var title: String

    constructor()

    constructor(id: Long, title: String) : super(id) {
        this.title = title
    }

}


