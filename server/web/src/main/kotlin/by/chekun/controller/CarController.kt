package by.chekun.controller


import by.chekun.controller.ControllerHelper.checkBindingResultAndThrowExceptionIfInvalid
import by.chekun.dto.car.CarRequestDto
import by.chekun.dto.car.PartialCarUpdate
import by.chekun.dto.car.view.CarDto
import by.chekun.dto.helper.PageWrapper
import by.chekun.dto.helper.Paging
import by.chekun.dto.search.CarSearchCriteria
import by.chekun.service.CarService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.Positive

@RestController
@RequestMapping("/cars")
@Validated
class CarController(private val carService: CarService) {

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

    ): ResponseEntity<PageWrapper<CarDto?>> {
        val paging = Paging(size, page)
        val searchCriteria = getSearchCriteria(model, releaseYear, minPrice, maxPrice, brandTitle, sortBy, sortType)
        val carPage = carService.findAll(paging, searchCriteria)

        return ResponseEntity(
            carPage,
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
    ): ResponseEntity<CarDto?> {
        val car = carService.findById(id)

        return ResponseEntity.ok(car)
    }

    @PostMapping
    fun save(
        @Valid @RequestBody car: CarRequestDto,
        result: BindingResult
    ): ResponseEntity<CarDto?> {
        checkBindingResultAndThrowExceptionIfInvalid(result)
        val saved = carService.save(car)
        val httpHeaders = HttpHeaders()
        if (saved != null) {
            httpHeaders.location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.id).toUri()
        }
        return ResponseEntity(saved, httpHeaders, HttpStatus.CREATED)
    }

    @PatchMapping("/{id}")
    fun partialUpdate(
        @PathVariable("id", required = true) carId: Long,
        @RequestParam("picture", required = false) picture: MultipartFile?
    ): ResponseEntity<CarDto?> {
        val partialCarUpdate = PartialCarUpdate()
        partialCarUpdate.picture = picture

        println(picture?.name)
        println(picture?.bytes?.size)
        val car = carService.partialUpdate(carId, partialCarUpdate)
        return ResponseEntity.ok(car)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<*>? {
        carService.delete(id)
        return ResponseEntity<Any>(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable
        @Positive(message = "Id must be positive!")
        id: Long,
        @Valid
        @RequestBody
        carBean: CarDto,
        result: BindingResult?
    ): ResponseEntity<CarDto?> {
        checkBindingResultAndThrowExceptionIfInvalid(result!!)
        carBean.id = id
        return ResponseEntity(
            carService.update(carBean),
            HttpStatus.OK
        )
    }
}
