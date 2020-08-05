package by.chekun.service.impl

import by.chekun.dto.CarDto
import by.chekun.dto.CarSearchCriteria
import by.chekun.dto.Paging
import by.chekun.dto.converter.CarEntityDtoConverter
import by.chekun.exception.ResourceNotFoundException
import by.chekun.repository.BrandRepository
import by.chekun.repository.CarRepository
import by.chekun.repository.specification.CarSpecification
import by.chekun.service.CarService
import org.springframework.data.domain.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class CarServiceImpl(
    private val carEntityDtoConverter: CarEntityDtoConverter,
    private val carRepository: CarRepository,
    private val brandRepository: BrandRepository
) : CarService {


    override fun findAll(paging: Paging, searchCriteria: CarSearchCriteria): Page<CarDto> {

        val pageable = getPageable(paging, searchCriteria.sortBy, searchCriteria.sortType)

        val specification = CarSpecification.getCarSpecification(
            searchCriteria.minPrice, searchCriteria.maxPrice,
            searchCriteria.brandTitle, searchCriteria.model,
            searchCriteria.releaseYear
        )

        val page = carRepository.findAll(specification, pageable)

        return PageImpl(carEntityDtoConverter.toDtoList(page.content), page.pageable, page.totalElements)
    }


    private fun getPageable(paging: Paging, sortBy: String, sortType: String): Pageable {
        val sort =
            if (sortType.equals("ASC", ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        return PageRequest.of(paging.page, paging.size, sort)
    }

    override fun findById(id: Long): CarDto {
        val car =
            carRepository.findById(id).orElseThrow { throw ResourceNotFoundException("Car with id $id not found!") }

        return carEntityDtoConverter.toDto(car)
    }

    @Transactional
    override fun save(carDto: CarDto): CarDto {


        brandRepository.findById(carDto.brand.id)
            .orElseThrow { throw ResourceNotFoundException("Can`t create car, because brand with id " + carDto.brand.id + " does not exist!") }

        val car = carEntityDtoConverter.toEntity(carDto)

        return carEntityDtoConverter.toDto(carRepository.save(car))
    }

    @Transactional
    override fun delete(id: Long) {
        val car =
            carRepository.findById(id).orElseThrow { throw ResourceNotFoundException("Car with id $id not found!") }

        carRepository.delete(car)
    }

    @Transactional
    override fun update(carDto: CarDto) {
        TODO("Not yet implemented")
    }

    override fun isPresent(id: Long): Boolean {
        return carRepository.findById(id).isPresent
    }

}
