package by.chekun.service

import by.chekun.dto.car.brand.BrandDto
import by.chekun.dto.car.brand.BrandListView

interface BrandService {

    fun findAll(): BrandListView

    fun findById(id: Long): BrandDto?

    fun save(brandDto: BrandDto): BrandDto?

    fun delete(id: Long)

    fun update(brandDto: BrandDto): BrandDto?

    fun isPresent(id: Long): Boolean
}