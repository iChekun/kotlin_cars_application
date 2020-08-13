package by.chekun.controller

import by.chekun.service.ChassisComponentService
import by.chekun.service.EquipmentComponentService
import by.chekun.service.InteriorComponentComponentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/components")
class ComponentController(
    private val interiorComponentService: InteriorComponentComponentService,
    private val equipmentComponentService: EquipmentComponentService,
    private val chassisComponentService: ChassisComponentService
) {

    @GetMapping("/interior")
    fun findAllInteriorComponents() = interiorComponentService.findAll()

    @GetMapping("/equipment")
    fun findAllEquipment() = equipmentComponentService.findAll()

    @GetMapping("/chassis")
    fun findAllChassis() = chassisComponentService.findAll()

}