package by.chekun.repository.chassis

import by.chekun.model.chassis.EngineType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EngineTypeRepository : JpaRepository<EngineType, Long>