package by.chekun.service

import by.chekun.dto.BrandDto

interface BrandService {

    fun findAll(): List<BrandDto>

    fun findById(id: Long): BrandDto

    fun save(brandDto: BrandDto): BrandDto

    fun delete(id: Long)

    fun update(brandDto: BrandDto)

    fun isPresent(id: Long): Boolean
}