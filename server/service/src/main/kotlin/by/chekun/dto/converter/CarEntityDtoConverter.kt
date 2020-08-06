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

        car.generation = d.generation
        car.mileage = d.mileage
        car.bodyType = d.bodyType
        car.transmissionType = d.transmissionType
        car.fuelType = d.fuelType
        car.wheelDriveType = d.wheelDriveType
        car.engineCapacity = d.engineCapacity
        car.picture = d.picture.copyOf()

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

        carDto.generation = e.generation
        carDto.mileage = e.mileage
        carDto.bodyType = e.bodyType
        carDto.transmissionType = e.transmissionType
        carDto.fuelType = e.fuelType
        carDto.wheelDriveType = e.wheelDriveType
        carDto.engineCapacity = e.engineCapacity
        carDto.picture = e.picture.copyOf()

        return carDto
    }

    override fun toDtoList(eList: List<Car>): List<CarDto> {
        return eList.stream().map { e -> toDto(e) }.collect(Collectors.toList())
    }

}