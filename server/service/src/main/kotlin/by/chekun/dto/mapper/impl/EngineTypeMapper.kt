package by.chekun.dto.mapper.impl

import by.chekun.dto.car.chassis.EngineTypeDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.chassis.EngineType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EngineTypeMapper @Autowired constructor() :
    AbstractMapper<EngineType, EngineTypeDto>(EngineType::class.java, EngineTypeDto::class.java)