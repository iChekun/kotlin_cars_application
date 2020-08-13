package by.chekun.repository.interior

import by.chekun.model.interior.InteriorMaterial
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InteriorMaterialRepository : JpaRepository<InteriorMaterial, Long>