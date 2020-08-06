package by.chekun.bean

import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CarBean : AbstractBean() {

    @NotBlank(message = "Please, choose car model!")
    lateinit var model: String

    @NotBlank(message = "Please, choose car generation!")
    lateinit var generation: String

    var mileage: Double = 0.0

    @NotBlank(message = "Please, choose car body type!")
    lateinit var bodyType: String

    @NotBlank(message = "Please, choose car transmission type!")
    lateinit var transmissionType: String

    @NotBlank(message = "Please, choose car fuel type!")
    lateinit var fuelType: String

    @NotBlank(message = "Please, choose car wheel drive type!")
    lateinit var wheelDriveType: String

    var engineCapacity: Double = 0.0

    @NotNull(message = "Price can`t be null")
    @Min(value = 0, message = "Price can`t be < 0")
    var releaseYear: Int = 0

    @NotNull(message = "Price can`t be null")
    @Min(value = 0, message = "Price can`t be < 0")
    var price: Double = 0.0

    var description: String = ""

    @Valid
    @NotNull(message = "Brand must be set!")
    lateinit var brand: BrandBean

    lateinit var picture: ByteArray

}