package by.chekun.service.impl

import by.chekun.dto.car.equipment.ColorDto
import by.chekun.dto.car.equipment.ConditionDto
import by.chekun.dto.car.equipment.EquipmentComponent
import by.chekun.dto.car.equipment.SafetyDto
import by.chekun.dto.mapper.Mapper
import by.chekun.model.equipment.Color
import by.chekun.model.equipment.Condition
import by.chekun.model.equipment.Safety
import by.chekun.repository.equipment.ColorRepository
import by.chekun.repository.equipment.ConditionRepository
import by.chekun.repository.equipment.SafetyRepository
import by.chekun.service.EquipmentComponentService
import org.springframework.stereotype.Service

@Service
class EquipmentComponentServiceImpl(
    private val colorRepository: ColorRepository,
    private val conditionRepository: ConditionRepository,
    private val safetyRepository: SafetyRepository,

    private val colorMapper: Mapper<Color, ColorDto>,
    private val conditionMapper: Mapper<Condition, ConditionDto>,
    private val safetyMapper: Mapper<Safety, SafetyDto>
) : EquipmentComponentService {

    override fun findAll(): EquipmentComponent {
        val colors = colorRepository.findAll()
        val conditions = conditionRepository.findAll()
        val safeties = safetyRepository.findAll()

        return EquipmentComponent(
            colorMapper.toDtoList(colors),
            conditionMapper.toDtoList(conditions),
            safetyMapper.toDtoList(safeties)
        )
    }
}