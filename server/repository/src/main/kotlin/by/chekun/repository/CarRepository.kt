package by.chekun.repository

import by.chekun.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<Car, Long>, JpaSpecificationExecutor<Car>