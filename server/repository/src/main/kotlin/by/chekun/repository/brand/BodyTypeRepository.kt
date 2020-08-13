package by.chekun.repository.brand

import by.chekun.model.brand.BodyType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BodyTypeRepository : JpaRepository<BodyType, Long>