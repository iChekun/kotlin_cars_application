package by.chekun.bean.converter.impl

import by.chekun.dto.CarDto
import by.chekun.bean.CarCreateBean
import by.chekun.bean.converter.RequestBeanDtoConverter
import by.chekun.service.BrandService
import org.springframework.stereotype.Component

@Component
class CarCreateBeanDtoConverter(private val brandService: BrandService) :
    RequestBeanDtoConverter<CarCreateBean, CarDto> {

    override fun toDto(b: CarCreateBean): CarDto {
        val car = CarDto()
        car.model = b.model
        car.releaseYear = b.releaseYear
        car.price = b.price
        car.description = b.description
        car.brand = brandService.findById(b.brandId)

        return car
    }

}