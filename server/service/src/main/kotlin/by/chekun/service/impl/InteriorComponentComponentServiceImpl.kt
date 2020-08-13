package by.chekun.service.impl

import by.chekun.dto.car.interior.InteriorColorDto
import by.chekun.dto.car.interior.InteriorComponent
import by.chekun.dto.car.interior.InteriorDto
import by.chekun.dto.car.interior.InteriorMaterialDto
import by.chekun.dto.mapper.Mapper
import by.chekun.model.interior.Interior
import by.chekun.model.interior.InteriorColor
import by.chekun.model.interior.InteriorMaterial
import by.chekun.repository.interior.InteriorColorRepository
import by.chekun.repository.interior.InteriorMaterialRepository
import by.chekun.repository.interior.InteriorRepository
import by.chekun.service.InteriorComponentComponentService
import org.springframework.stereotype.Service

@Service
class InteriorComponentComponentServiceImpl(
    private val interiorColorRepository: InteriorColorRepository,
    private val interiorRepository: InteriorRepository,
    private val interiorMaterialRepository: InteriorMaterialRepository,

    private val interiorColorMapper: Mapper<InteriorColor, InteriorColorDto>,
    private val interiorMapper: Mapper<Interior, InteriorDto>,
    private val interiorMaterialMapper: Mapper<InteriorMaterial, InteriorMaterialDto>
) : InteriorComponentComponentService {

    override fun findAll(): InteriorComponent {
        val interiorColors = interiorColorRepository.findAll()
        val interior = interiorRepository.findAll()
        val interiorMaterials = interiorMaterialRepository.findAll()

        return InteriorComponent(
            interiorColorMapper.toDtoList(interiorColors),
            interiorMapper.toDtoList(interior),
            interiorMaterialMapper.toDtoList(interiorMaterials)
        )
    }


}