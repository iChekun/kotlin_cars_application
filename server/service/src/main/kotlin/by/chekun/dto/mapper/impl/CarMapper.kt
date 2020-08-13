package by.chekun.dto.mapper.impl

import by.chekun.dto.car.view.CarDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.Car
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CarMapper @Autowired constructor() :
    AbstractMapper<Car, CarDto>(Car::class.java, CarDto::class.java)