package by.chekun.dto.car.view

import by.chekun.dto.AbstractDto
import by.chekun.dto.car.MileageDto
import by.chekun.dto.car.brand.BodyTypeDto
import by.chekun.dto.car.chassis.EngineTypeDto
import by.chekun.dto.car.chassis.TransmissionTypeDto
import by.chekun.dto.car.chassis.WheelDriveTypeDto
import by.chekun.dto.car.equipment.ColorDto
import by.chekun.dto.car.equipment.ConditionDto
import by.chekun.dto.car.equipment.SafetyDto
import by.chekun.dto.car.interior.InteriorColorDto
import by.chekun.dto.car.interior.InteriorDto
import by.chekun.dto.car.interior.InteriorMaterialDto
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.*


class CarDto() : AbstractDto() {

    lateinit var brand: CarBrandDto

    lateinit var model: CarModelDto

    lateinit var releaseYear: CarReleaseYearDto

    lateinit var generation: CarGenerationDto

    lateinit var bodyType: BodyTypeDto

    lateinit var color: ColorDto

    lateinit var condition: ConditionDto

    lateinit var mileage: MileageDto

    lateinit var interiorColor: InteriorColorDto

    lateinit var interiorMaterial: InteriorMaterialDto

    var safeties: Set<SafetyDto> = HashSet()

    var interior: Set<InteriorDto> = HashSet()

    lateinit var engineType: EngineTypeDto

    var engineCapacity: Double = 0.0

    lateinit var transmissionType: TransmissionTypeDto

    lateinit var wheelDriveType: WheelDriveTypeDto

    var price: Double = 0.0

    lateinit var description: String

    var picture: ByteArray? = null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var dateOfCreation: LocalDateTime? = null

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var dateOfModification: LocalDateTime? = null
}
