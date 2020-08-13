package by.chekun.repository.equipment

import by.chekun.model.equipment.Safety
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SafetyRepository : JpaRepository<Safety, Long>