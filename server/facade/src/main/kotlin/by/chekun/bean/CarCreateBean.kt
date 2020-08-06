package by.chekun.bean

import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CarCreateBean(

    @NotBlank(message = "Please, choose car model!")
    val model: String,

    @NotBlank(message = "Please, choose car generation!")
    val generation: String,

    @NotNull(message = "Please, choose car mileage!")
    val mileage: Double,

    @NotBlank(message = "Please, choose car body type!")
    val bodyType: String,

    @NotBlank(message = "Please, choose car transmission type!")
    val transmissionType: String,

    @NotBlank(message = "Please, choose car fuel type!")
    val fuelType: String,

    @NotBlank(message = "Please, choose car wheel drive type!")
    val wheelDriveType: String,

    @NotNull(message = "Please, choose car wheel engine capacity")
    val engineCapacity: Double,

    @NotNull(message = "Release year can`t be null")
    @Min(value = 1930, message = "Release year count can`t be < 0")
    val releaseYear: Int,

    @NotNull(message = "Price can`t be null")
    @Min(value = 0, message = "Price can`t be < 0")
    val price: Double,

    val description: String = "",

    @Valid
    @NotNull(message = "Brand must be set!")
    val brandId: Long,

    val picture: MultipartFile
)