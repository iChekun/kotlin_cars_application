package by.chekun.bean

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CarRequestBean : AbstractBean() {

//    @field:Null(message = "Id")
//    var id: Long,

    @field:NotBlank(message = "Please, choose car model!")
    lateinit var model: String

    @field:NotBlank(message = "Please, choose car generation!")
    lateinit var generation: String

    @field:NotNull(message = "Please, choose car mileage!")
    var mileage: Double = 0.0

    @field:NotBlank(message = "Please, choose car body type!")
    lateinit var bodyType: String

    @field:NotBlank(message = "Please, choose car transmission type!")
    lateinit var transmissionType: String

    @field:NotBlank(message = "Please, choose car fuel type!")
    lateinit var fuelType: String

    @field:NotBlank(message = "Please, choose car wheel drive type!")
    lateinit var wheelDriveType: String

    @field:NotNull(message = "Please, choose car wheel engine capacity")
    var engineCapacity: Double = 0.0

    @field:NotNull(message = "Release year can`t be null")
    @field:Min(value = 1930, message = "Release year count can`t be < 0")
    var releaseYear: Int = 0

    @field:NotNull(message = "Price can`t be null")
    @field:Min(value = 0, message = "Price can`t be < 0")
    var price: Double = 0.0

    var description: String = ""

    @field:NotNull(message = "Brand must be set!")
    var brandId: Long = 0

    var picture: MultipartFile? = null

}