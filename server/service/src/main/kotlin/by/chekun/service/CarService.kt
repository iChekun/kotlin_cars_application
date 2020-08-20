package by.chekun.service

import by.chekun.dto.car.CarRequestDto
import by.chekun.dto.car.PartialCarUpdate
import by.chekun.dto.car.view.CarDto
import by.chekun.dto.helper.PageWrapper
import by.chekun.dto.helper.Paging
import by.chekun.dto.search.CarSearchCriteria

interface CarService {

    fun findAll(paging: Paging, searchCriteria: CarSearchCriteria): PageWrapper<CarDto?>

    fun findById(id: Long): CarDto?

    fun save(carDto: CarRequestDto): CarDto?

    fun delete(id: Long)

    fun update(carDto: CarDto): CarDto?

    fun partialUpdate(carId: Long, partialCarUpdate: PartialCarUpdate): CarDto?

    fun isPresent(id: Long): Boolean
}