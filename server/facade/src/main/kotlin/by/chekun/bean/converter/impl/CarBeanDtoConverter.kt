package by.chekun.bean.converter.impl

import by.chekun.dto.CarDto
import by.chekun.bean.CarBean
import by.chekun.bean.converter.Converter
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CarBeanDtoConverter(private val brandBeanDtoConverter: BrandBeanDtoConverter) :
    Converter<CarBean, CarDto> {


    override fun toDto(b: CarBean): CarDto {
        val car = CarDto()
        car.id = b.id
        car.model = b.model
        car.releaseYear = b.releaseYear
        car.price = b.price
        car.description = b.description
        car.brand = brandBeanDtoConverter.toDto(b.brand)

        return car
    }

    override fun toBean(d: CarDto): CarBean {
        val car = CarBean()
        car.id = d.id
        car.model = d.model
        car.releaseYear = d.releaseYear
        car.price = d.price
        car.description = d.description
        car.brand = brandBeanDtoConverter.toBean(d.brand)

        return car
    }

    override fun toBeanList(eList: List<CarDto>): List<CarBean> {
        return eList.stream().map { e -> toBean(e) }.collect(Collectors.toList())
    }

}