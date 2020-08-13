package by.chekun.dto.mapper.impl

import by.chekun.dto.car.equipment.ColorDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.equipment.Color
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ColorMapper @Autowired constructor() :
    AbstractMapper<Color, ColorDto>(Color::class.java, ColorDto::class.java)