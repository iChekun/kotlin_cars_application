package by.chekun.repository.equipment

import by.chekun.model.equipment.Condition
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConditionRepository : JpaRepository<Condition, Long>