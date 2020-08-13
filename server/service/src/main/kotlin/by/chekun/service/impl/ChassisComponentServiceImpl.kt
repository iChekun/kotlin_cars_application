package by.chekun.service.impl

import by.chekun.dto.car.chassis.ChassisComponent
import by.chekun.dto.car.chassis.EngineTypeDto
import by.chekun.dto.car.chassis.TransmissionTypeDto
import by.chekun.dto.car.chassis.WheelDriveTypeDto
import by.chekun.dto.mapper.Mapper
import by.chekun.model.chassis.EngineType
import by.chekun.model.chassis.TransmissionType
import by.chekun.model.chassis.WheelDriveType
import by.chekun.repository.chassis.EngineTypeRepository
import by.chekun.repository.chassis.TransmissionTypeRepository
import by.chekun.repository.chassis.WheelDriveTypeRepository
import by.chekun.service.ChassisComponentService
import org.springframework.stereotype.Service

@Service
class ChassisComponentServiceImpl(
    private val engineTypeRepository: EngineTypeRepository,
    private val transmissionTypeRepository: TransmissionTypeRepository,
    private val wheelDriveTypeRepository: WheelDriveTypeRepository,

    private val engineTypeMapper: Mapper<EngineType, EngineTypeDto>,
    private val transmissionTypeMapper: Mapper<TransmissionType, TransmissionTypeDto>,
    private val wheelDriveTypeMapper: Mapper<WheelDriveType, WheelDriveTypeDto>
) : ChassisComponentService {

    override fun findAll(): ChassisComponent {
        val engineTypes = engineTypeRepository.findAll()
        val transmissionTypes = transmissionTypeRepository.findAll()
        val wheelDriveTypes = wheelDriveTypeRepository.findAll()

        return ChassisComponent(
            engineTypeMapper.toDtoList(engineTypes),
            transmissionTypeMapper.toDtoList(transmissionTypes),
            wheelDriveTypeMapper.toDtoList(wheelDriveTypes)
        )
    }

}