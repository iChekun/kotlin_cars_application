package by.chekun.repository.interior

import by.chekun.model.interior.Interior
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InteriorRepository : JpaRepository<Interior, Long>