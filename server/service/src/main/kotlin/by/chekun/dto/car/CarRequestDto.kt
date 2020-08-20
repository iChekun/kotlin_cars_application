package by.chekun.dto.car

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotNull

class CarRequestDto {

    //@NotNull(message = "Brand must be selected")
    var brandId: Long = 0

   // @NotNull(message = "Model must be selected")
    var modelId: Long = 0

   // @NotNull(message = "Release year must be selected")
    var releaseYear: Int = 0

   // @NotNull(message = "Generation must be selected")
    var generationId: Long = 0

   // @NotNull(message = "Body type must be selected")
    var bodyTypeId: Long = 0

   // @NotNull(message = "Color must be selected")
    var colorId: Long = 0

   // @NotNull(message = "Condition must be selected")
    var conditionId: Long = 0

  //  @NotNull(message = "Mileage must be selected")
    lateinit var mileage: MileageDto

   // @NotNull(message = "Interior color must be selected")
    var interiorColorId: Long = 0

   // @NotNull(message = "Interior material must be selected")
    var interiorMaterialId: Long = 0

    var safetyIds: List<Long> = ArrayList()

    var interiorIds: List<Long> = ArrayList()

   // @NotNull(message = "Engine must be selected")
    var engineTypeId: Long = 0

   // @NotNull(message = "Engine capacity must be selected")
    var engineCapacity: Double = 0.0

   // @NotNull(message = "Transmission type must be selected")
    var transmissionTypeId: Long = 0

   // @NotNull(message = "Wheel drive type must be selected")
    var wheelDriveTypeId: Long = 0

   // @NotNull(message = "price must be selected")
    var price: Double = 0.0

    var description: String = ""

    var picture: MultipartFile? = null
}