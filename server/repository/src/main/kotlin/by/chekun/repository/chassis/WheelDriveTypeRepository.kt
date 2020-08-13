package by.chekun.repository.chassis

import by.chekun.model.chassis.WheelDriveType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WheelDriveTypeRepository : JpaRepository<WheelDriveType, Long>