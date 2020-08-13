package by.chekun.dto.mapper.impl

import by.chekun.dto.car.interior.InteriorColorDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.interior.InteriorColor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InteriorColorMapper @Autowired constructor() :
    AbstractMapper<InteriorColor, InteriorColorDto>(InteriorColor::class.java, InteriorColorDto::class.java)