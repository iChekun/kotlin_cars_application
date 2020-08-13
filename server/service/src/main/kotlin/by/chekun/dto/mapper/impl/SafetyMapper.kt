package by.chekun.dto.mapper.impl

import by.chekun.dto.car.equipment.SafetyDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.equipment.Safety
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SafetyMapper @Autowired constructor() :
    AbstractMapper<Safety, SafetyDto>(Safety::class.java, SafetyDto::class.java)