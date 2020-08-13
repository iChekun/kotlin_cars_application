package by.chekun.repository.brand

import by.chekun.model.brand.Brand
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BrandRepository : JpaRepository<Brand, Long> {
    fun findByTitle(title: String): Optional<Brand>
}