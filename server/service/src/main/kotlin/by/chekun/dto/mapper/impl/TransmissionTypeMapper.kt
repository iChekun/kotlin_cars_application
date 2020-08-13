package by.chekun.dto.mapper.impl

import by.chekun.dto.car.chassis.TransmissionTypeDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.chassis.TransmissionType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TransmissionTypeMapper @Autowired constructor() :
    AbstractMapper<TransmissionType, TransmissionTypeDto>(TransmissionType::class.java, TransmissionTypeDto::class.java)