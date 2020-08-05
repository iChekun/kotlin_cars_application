package by.chekun.repository

import by.chekun.model.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BrandRepository : JpaRepository<Brand, Long> {
    fun findByTitle(title: String): Optional<Brand>
}