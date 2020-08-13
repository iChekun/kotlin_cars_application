package by.chekun.service.impl


import by.chekun.dto.car.CarRequestDto
import by.chekun.dto.car.view.CarDto
import by.chekun.dto.helper.PageWrapper
import by.chekun.dto.helper.Paging
import by.chekun.dto.mapper.impl.CarMapper
import by.chekun.dto.search.CarSearchCriteria
import by.chekun.exception.ResourceNotFoundException
import by.chekun.model.Car
import by.chekun.model.Mileage
import by.chekun.model.equipment.Safety
import by.chekun.model.interior.Interior
import by.chekun.repository.brand.*
import by.chekun.repository.car.CarRepository
import by.chekun.repository.chassis.EngineTypeRepository
import by.chekun.repository.chassis.TransmissionTypeRepository
import by.chekun.repository.chassis.WheelDriveTypeRepository
import by.chekun.repository.equipment.ColorRepository
import by.chekun.repository.equipment.ConditionRepository
import by.chekun.repository.equipment.SafetyRepository
import by.chekun.repository.interior.InteriorColorRepository
import by.chekun.repository.interior.InteriorMaterialRepository
import by.chekun.repository.interior.InteriorRepository
import by.chekun.repository.specification.CarSpecification
import by.chekun.service.CarService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CarServiceImpl(

    private val carMapper: CarMapper,

    private val carRepository: CarRepository,

    private val brandRepository: BrandRepository,
    private val bodyTypeRepository: BodyTypeRepository,
    private val generationRepository: GenerationRepository,
    private val modelRepository: ModelRepository,
    private val releaseYearRepository: ReleaseYearRepository,

    private val colorRepository: ColorRepository,
    private val conditionRepository: ConditionRepository,
    private val safetyRepository: SafetyRepository,


    private val engineTypeRepository: EngineTypeRepository,
    private val transmissionTypeRepository: TransmissionTypeRepository,
    private val wheelDriveTypeRepository: WheelDriveTypeRepository,

    private val interiorColorRepository: InteriorColorRepository,
    private val interiorRepository: InteriorRepository,
    private val interiorMaterialRepository: InteriorMaterialRepository

) : CarService {


    @Transactional
    override fun save(carDto: CarRequestDto): CarDto? {

        //resolve all entities
        val car = getCar(carDto)

        println(car)
        // val car = carMapper.toEntity(carDto)

        return carMapper.toDto(carRepository.save(car))
    }

    private fun getCar(carDto: CarRequestDto): Car {

        val brand = brandRepository.findById(carDto.brandId)
            .orElseThrow { throw ResourceNotFoundException("Brand with id= " + carDto.brandId + " does not exist!") }
        val bodyType = bodyTypeRepository.findById(carDto.bodyTypeId)
            .orElseThrow { throw ResourceNotFoundException("Body type with id " + carDto.bodyTypeId + " does not exist!") }
        val generation = generationRepository.findById(carDto.generationId)
            .orElseThrow { throw ResourceNotFoundException("Generation with id " + carDto.generationId + " does not exist!") }
        val model = modelRepository.findById(carDto.modelId)
            .orElseThrow { throw ResourceNotFoundException("Model with id " + carDto.modelId + " does not exist!") }
        val releaseYear = releaseYearRepository.findByReleaseYear(carDto.releaseYear)
            .orElseThrow { throw ResourceNotFoundException("Release year = " + carDto.releaseYear + " does not exist!") }
        /////
        val color = colorRepository.findById(carDto.colorId)
            .orElseThrow { throw ResourceNotFoundException("Color with id " + carDto.modelId + " does not exist!") }
        val condition = conditionRepository.findById(carDto.conditionId)
            .orElseThrow { throw ResourceNotFoundException("Condition with id " + carDto.modelId + " does not exist!") }

        val safeties: MutableSet<Safety> = HashSet()
        carDto.safetyIds.forEach { safetyId ->
            val safety = safetyRepository.findById(safetyId)
                .orElseThrow { throw ResourceNotFoundException("Safety with id= $safetyId does not exist!") }
            safeties.add(safety)
        }

        //////
        val engineType = engineTypeRepository.findById(carDto.engineTypeId)
            .orElseThrow { throw ResourceNotFoundException("Car engine with id= " + carDto.engineTypeId + " does not exist!") }
        val transmissionType = transmissionTypeRepository.findById(carDto.transmissionTypeId)
            .orElseThrow { throw ResourceNotFoundException("Transmission with id= " + carDto.transmissionTypeId + " does not exist!") }
        val wheelDriveType = wheelDriveTypeRepository.findById(carDto.wheelDriveTypeId)
            .orElseThrow { throw ResourceNotFoundException("Wheel drive type with id= " + carDto.wheelDriveTypeId + " does not exist!") }
        ///////

        val interiorColor = interiorColorRepository.findById(carDto.interiorColorId)
            .orElseThrow { throw ResourceNotFoundException("Color with id " + carDto.interiorColorId + " does not exist!") }

        val interior: MutableSet<Interior> = HashSet()
        carDto.interiorIds.forEach { interiorId ->
            val interiorEntity = interiorRepository.findById(interiorId)
                .orElseThrow { throw ResourceNotFoundException("Interior with id= $interiorId does not exist!") }
            interior.add(interiorEntity)
        }

        val interiorMaterial = interiorMaterialRepository.findById(carDto.interiorMaterialId)
            .orElseThrow { throw ResourceNotFoundException("Interior material with id " + carDto.interiorMaterialId + " does not exist!") }

        val mileage = Mileage(carDto.mileage.mileage, carDto.mileage.measurement)
        val car = Car()
        car.brand = brand
        car.model = model
        car.releaseYear = releaseYear
        car.generation = generation
        car.bodyType = bodyType
        car.color = color
        car.condition = condition
        car.mileage = mileage
        car.interiorColor = interiorColor
        car.interiorMaterial = interiorMaterial
        car.safeties = safeties
        car.interior = interior
        car.engineType = engineType
        car.engineCapacity = carDto.engineCapacity
        car.transmissionType = transmissionType
        car.wheelDriveType = wheelDriveType
        car.price = carDto.price
        car.description = carDto.description

        return car
    }

    @Transactional(readOnly = true)
    override fun findAll(paging: Paging, searchCriteria: CarSearchCriteria): PageWrapper<CarDto?> {

        val pageable = getPageable(paging, searchCriteria.sortBy, searchCriteria.sortType)

        val specification = CarSpecification.getCarSpecification(
            searchCriteria.minPrice, searchCriteria.maxPrice,
            searchCriteria.brandTitle, searchCriteria.model,
            searchCriteria.releaseYear
        )

        val page = carRepository.findAll(specification, pageable)

        // return PageImpl(carMapper.toDtoList(page.content), page.pageable, page.totalElements)
        return PageWrapper.of(
            carMapper.toDtoList(page.toList()),
            page.totalPages,
            page.totalElements,
            paging.page,
            page.numberOfElements
        )
    }


    private fun getPageable(paging: Paging, sortBy: String, sortType: String): Pageable {
        val sort =
            if (sortType.equals("ASC", ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        return PageRequest.of(paging.page, paging.size, sort)
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): CarDto? {
        val car =
            carRepository.findById(id).orElseThrow { throw ResourceNotFoundException("Car with id $id not found!") }

        return carMapper.toDto(car)
    }


    @Transactional
    override fun delete(id: Long) {
        val car =
            carRepository.findById(id).orElseThrow { throw ResourceNotFoundException("Car with id $id not found!") }

        carRepository.delete(car)
    }

    @Transactional
    override fun update(carDto: CarDto): CarDto? {
        val car =
            carRepository.findById(carDto.id)
                .orElseThrow { throw ResourceNotFoundException("Car with id " + carDto.id + "not found!") }

        val updatedCar = carRepository.save(carMapper.toEntity(carDto))

        return carMapper.toDto(updatedCar!!)
    }

    @Transactional(readOnly = true)
    override fun isPresent(id: Long): Boolean {
        return carRepository.findById(id).isPresent
    }

}
