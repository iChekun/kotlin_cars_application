package by.chekun.dto.mapper.impl

import by.chekun.dto.car.equipment.ConditionDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.equipment.Condition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ConditionMapper @Autowired constructor() :
    AbstractMapper<Condition, ConditionDto>(Condition::class.java, ConditionDto::class.java)