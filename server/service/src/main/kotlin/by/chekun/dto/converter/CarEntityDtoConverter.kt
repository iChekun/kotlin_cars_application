package by.chekun.dto.converter

import by.chekun.dto.CarDto
import by.chekun.model.Car
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class CarEntityDtoConverter(private val brandEntityDtoConverter: BrandEntityDtoConverter) : Converter<CarDto, Car> {

    override fun toEntity(d: CarDto): Car {
        val car = Car()
        car.id = d.id
        car.model = d.model
        car.releaseYear = d.releaseYear
        car.price = d.price
        car.description = d.description
        car.brand = brandEntityDtoConverter.toEntity(d.brand)

        return car
    }

    override fun toDto(e: Car): CarDto {
        val carDto = CarDto()
        carDto.id = e.id
        carDto.model = e.model
        carDto.releaseYear = e.releaseYear
        carDto.price = e.price
        carDto.description = e.description
        carDto.brand = brandEntityDtoConverter.toDto(e.brand)

        return carDto
    }

    override fun toDtoList(eList: List<Car>): List<CarDto> {
        return eList.stream().map { e -> toDto(e) }.collect(Collectors.toList())
    }

}