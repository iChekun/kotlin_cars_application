package by.chekun.repository.brand

import by.chekun.model.brand.Generation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenerationRepository : JpaRepository<Generation, Long>