package by.chekun.repository.brand

import by.chekun.model.brand.ReleaseYear
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ReleaseYearRepository : JpaRepository<ReleaseYear, Long> {

    fun findByReleaseYear(releaseYear: Int): Optional<ReleaseYear>
}