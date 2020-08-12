package by.chekun.bean.converter.impl

import by.chekun.bean.CarRequestBean
import by.chekun.bean.converter.RequestBeanDtoConverter
import by.chekun.dto.CarDto
import by.chekun.service.BrandService
import org.springframework.stereotype.Component

@Component
class CarRequestBeanDtoConverter(private val brandService: BrandService) :
    RequestBeanDtoConverter<CarRequestBean, CarDto> {

    override fun toDto(b: CarRequestBean): CarDto {
        val carDto = CarDto()
        carDto.id = b.id
        carDto.model = b.model
        carDto.releaseYear = b.releaseYear
        carDto.price = b.price
        carDto.description = b.description
        carDto.brand = brandService.findById(b.brandId)

        carDto.generation = b.generation
        carDto.mileage = b.mileage
        carDto.bodyType = b.bodyType
        carDto.transmissionType = b.transmissionType
        carDto.fuelType = b.fuelType
        carDto.wheelDriveType = b.wheelDriveType
        carDto.engineCapacity = b.engineCapacity

        carDto.picture = b.picture?.bytes?.copyOf()

        return carDto
    }

}