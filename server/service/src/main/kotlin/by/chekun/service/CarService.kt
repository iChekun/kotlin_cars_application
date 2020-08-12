package by.chekun.service

import by.chekun.dto.CarDto
import by.chekun.dto.CarSearchCriteria
import by.chekun.dto.Paging
import org.springframework.data.domain.Page

interface CarService {

    fun findAll(paging: Paging, searchCriteria: CarSearchCriteria): Page<CarDto>

    fun findById(id: Long): CarDto

    fun save(carDto: CarDto): CarDto

    fun delete(id: Long)

    fun update(carDto: CarDto): CarDto

    fun isPresent(id: Long): Boolean
}