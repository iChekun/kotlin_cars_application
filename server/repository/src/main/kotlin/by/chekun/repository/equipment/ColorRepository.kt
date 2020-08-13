package by.chekun.repository.equipment

import by.chekun.model.equipment.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ColorRepository : JpaRepository<Color, Long>