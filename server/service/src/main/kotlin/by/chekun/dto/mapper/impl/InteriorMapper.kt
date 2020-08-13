package by.chekun.dto.mapper.impl

import by.chekun.dto.car.interior.InteriorDto
import by.chekun.dto.mapper.AbstractMapper
import by.chekun.model.interior.Interior
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InteriorMapper @Autowired constructor() :
    AbstractMapper<Interior, InteriorDto>(Interior::class.java, InteriorDto::class.java)