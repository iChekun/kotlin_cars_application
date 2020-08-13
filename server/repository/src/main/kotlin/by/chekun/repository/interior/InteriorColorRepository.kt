package by.chekun.repository.interior

import by.chekun.model.interior.InteriorColor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InteriorColorRepository : JpaRepository<InteriorColor, Long>