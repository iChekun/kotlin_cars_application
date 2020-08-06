package by.chekun.controller

import by.chekun.bean.CarBean
import by.chekun.bean.CarCreateBean
import by.chekun.controller.ControllerHelper.checkBindingResultAndThrowExceptionIfInvalid
import by.chekun.dto.CarSearchCriteria
import by.chekun.dto.Paging
import by.chekun.facade.CarFacade
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.Positive

@RestController
@RequestMapping("/cars")
class CarController(private val carFacade: CarFacade) {

    @GetMapping
    fun findAll(

        @RequestParam(value = "size", defaultValue = "10")
        @Positive(message = "Id must be positive!") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int,

        @RequestParam(value = "model", required = false) model: String?,
        @RequestParam(value = "releaseYear", required = false) releaseYear: Int?,

        @RequestParam(value = "minPrice", required = false)
        @Min(value = 0, message = "Price can`t be smaller then 0") minPrice: Double?,

        @RequestParam(value = "maxPrice", required = false)
        @Min(value = 0, message = "Price can`t be smaller then 0") maxPrice: Double?,

        @RequestParam(value = "brandTitle", required = false) brandTitle: String?,

        @RequestParam(value = "sortBy", required = false, defaultValue = "price") sortBy: String,
        @RequestParam(value = "sortType", required = false, defaultValue = "ASC") sortType: String

    ): ResponseEntity<List<CarBean>> {
        val paging = Paging(size, page)
        val searchCriteria = getSearchCriteria(model, releaseYear, minPrice, maxPrice, brandTitle, sortBy, sortType)
        val cars = carFacade.findAll(paging, searchCriteria)

        return ResponseEntity(
            cars.objects,
            HttpStatus.OK
        )
    }

    private fun getSearchCriteria(
        model: String?,
        releaseYear: Int?,
        minPrice: Double?,
        maxPrice: Double?,
        brandTitle: String?,
        sortBy: String,
        sortType: String
    ): CarSearchCriteria {
        return CarSearchCriteria(
            model, releaseYear, minPrice, maxPrice, brandTitle, sortBy, sortType
        )
    }

    @GetMapping("/{id}")
    fun findById(
        @Min(
            value = 0,
            message = "Id can`t be <0"
        )
        @PathVariable(value = "id") id: Long
    ): ResponseEntity<CarBean> {
        val car = carFacade.findById(id)

        return ResponseEntity.ok(car)
    }

    @PostMapping
    fun save(
        @Valid @RequestBody carBean: CarCreateBean,
        result: BindingResult
    ): ResponseEntity<CarBean> {
        checkBindingResultAndThrowExceptionIfInvalid(result)
        val saved = carFacade.save(carBean)
        val httpHeaders = HttpHeaders()
        httpHeaders.location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(saved.id).toUri()
        return ResponseEntity(saved, httpHeaders, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<*>? {
        carFacade.delete(id)
        return ResponseEntity<Any>(HttpStatus.NO_CONTENT)
    }

}