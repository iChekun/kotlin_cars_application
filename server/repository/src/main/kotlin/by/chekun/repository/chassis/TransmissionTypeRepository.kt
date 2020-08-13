package by.chekun.repository.chassis

import by.chekun.model.chassis.TransmissionType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransmissionTypeRepository : JpaRepository<TransmissionType, Long>