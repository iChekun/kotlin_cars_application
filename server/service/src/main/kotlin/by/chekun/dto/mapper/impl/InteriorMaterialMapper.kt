package by.chekun.dto.mapper.impl

import by.chekun.dto.car.interior.InteriorMaterialDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.interior.InteriorMaterial
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InteriorMaterialMapper @Autowired constructor() :
    AbstractMapper<InteriorMaterial, InteriorMaterialDto>(InteriorMaterial::class.java, InteriorMaterialDto::class.java)