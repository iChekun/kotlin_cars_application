package by.chekun.bean.converter.impl

import by.chekun.bean.CarBean
import by.chekun.bean.converter.Converter
import by.chekun.dto.CarDto
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CarBeanDtoConverter(private val brandBeanDtoConverter: BrandBeanDtoConverter) :
    Converter<CarBean, CarDto> {


    override fun toDto(b: CarBean): CarDto {
        val carDto = CarDto()
        carDto.id = b.id
        carDto.model = b.model
        carDto.releaseYear = b.releaseYear
        carDto.price = b.price
        carDto.description = b.description
        carDto.brand = brandBeanDtoConverter.toDto(b.brand)

        carDto.generation = b.generation
        carDto.mileage = b.mileage
        carDto.bodyType = b.bodyType
        carDto.transmissionType = b.transmissionType
        carDto.fuelType = b.fuelType
        carDto.wheelDriveType = b.wheelDriveType
        carDto.engineCapacity = b.engineCapacity

        return carDto
    }

    override fun toBean(d: CarDto): CarBean {
        val carBean = CarBean()
        carBean.id = d.id
        carBean.model = d.model
        carBean.releaseYear = d.releaseYear
        carBean.price = d.price
        carBean.description = d.description
        carBean.brand = brandBeanDtoConverter.toBean(d.brand)

        carBean.generation = d.generation
        carBean.mileage = d.mileage
        carBean.bodyType = d.bodyType
        carBean.transmissionType = d.transmissionType
        carBean.fuelType = d.fuelType
        carBean.wheelDriveType = d.wheelDriveType
        carBean.engineCapacity = d.engineCapacity

        return carBean
    }

    override fun toBeanList(eList: List<CarDto>): List<CarBean> {
        return eList.stream().map { e -> toBean(e) }.collect(Collectors.toList())
    }

}