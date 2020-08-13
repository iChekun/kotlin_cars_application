package by.chekun.dto.mapper.impl

import by.chekun.dto.car.chassis.WheelDriveTypeDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.chassis.WheelDriveType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class WheelDriveTypeMapper @Autowired constructor() :
    AbstractMapper<WheelDriveType, WheelDriveTypeDto>(WheelDriveType::class.java, WheelDriveTypeDto::class.java)