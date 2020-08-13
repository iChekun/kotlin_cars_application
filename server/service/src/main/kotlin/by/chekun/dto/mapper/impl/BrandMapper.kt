package by.chekun.dto.mapper.impl


import by.chekun.dto.car.brand.BrandDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.brand.Brand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class BrandMapper @Autowired constructor() :
    AbstractMapper<Brand, BrandDto>(Brand::class.java, BrandDto::class.java)
