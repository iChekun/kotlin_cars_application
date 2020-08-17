package by.chekun.repository.database.entity.car


class CarRequestDto {

    var brandId: Long = 0

    var modelId: Long = 0

    var releaseYear: Int = 0

    var generationId: Long = 0

    var bodyTypeId: Long = 0

    var colorId: Long = 0

    var conditionId: Long = 0

    lateinit var mileage: MileageDto

    var interiorColorId: Long = 0

    var interiorMaterialId: Long = 0

//    var safetyIds: List<Long> = ArrayList()
//
//    var interiorIds: List<Long> = ArrayList()

    var engineTypeId: Long = 0

    var engineCapacity: Double = 0.0

    var transmissionTypeId: Long = 0

    var wheelDriveTypeId: Long = 0

    var price: Double = 0.0

    var description: String = ""

//    var picture: ByteArray? = null

}