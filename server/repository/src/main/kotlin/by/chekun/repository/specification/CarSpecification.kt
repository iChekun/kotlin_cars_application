package by.chekun.repository.specification

import by.chekun.model.Car
import org.springframework.data.jpa.domain.Specification
import java.util.*
import javax.persistence.criteria.Predicate


object CarSpecification {

    fun getCarSpecification(
        minPrice: Double?,
        maxPrice: Double?,
        brandTitle: String?,
        model: String?,
        releaseYear: Int?
    ): Specification<Car> {
        return Specification { root, query, criteriaBuilder ->

            val predicates: MutableCollection<Predicate> = ArrayList()

            if (Objects.nonNull(model)) {
                val predicate = criteriaBuilder.equal(root.get<Any>("model"), model)
                predicates.add(predicate)
            }
            if (minPrice != null && maxPrice != null) {
                val predicate = criteriaBuilder.between(root.get("price"), minPrice, maxPrice)
                predicates.add(predicate)
            }
            if (Objects.nonNull(brandTitle)) {
                val predicate = criteriaBuilder.equal(root.join<Any, Any>("brand").get<Any>("title"), brandTitle)
                predicates.add(predicate)
            }
            if (Objects.nonNull(releaseYear)) {
                val predicate = criteriaBuilder.equal(root.get<Any>("releaseYear"), releaseYear)
                predicates.add(predicate)
            }

            criteriaBuilder.and(*predicates.toTypedArray())
        }
    }


}