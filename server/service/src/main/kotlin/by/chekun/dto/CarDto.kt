package by.chekun.dto

import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


class CarDto : AbstractDto() {

    @NotBlank(message = "Please, choose car model!")
    lateinit var model: String

    @NotNull(message = "Price can`t be null")
    @Min(value = 0, message = "Price can`t be < 0")
    var releaseYear: Int = 0

    @NotNull(message = "Price can`t be null")
    @Min(value = 0, message = "Price can`t be < 0")
    var price: Double = 0.0

    var description: String = ""

    @Valid
    @NotNull(message = "Brand must be set!")
    lateinit var brand: BrandDto

}