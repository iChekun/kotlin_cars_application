package by.chekun.bean

import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CarCreateBean(

    @NotBlank(message = "Please, choose car model!")
    val model: String,

    @NotNull(message = "Release year can`t be null")
    @Min(value = 1930, message = "Release year count can`t be < 0")
    val releaseYear: Int,

    @NotNull(message = "Price can`t be null")
    @Min(value = 0, message = "Price can`t be < 0")
    val price: Double,

    val description: String = "",

    @Valid
    @NotNull(message = "Brand must be set!")
    val brandId: Long

)