package by.chekun.controller


import by.chekun.controller.ControllerHelper.checkBindingResultAndThrowExceptionIfInvalid
import by.chekun.dto.car.brand.BrandDto
import by.chekun.dto.car.brand.BrandListView
import by.chekun.service.BrandService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid
import javax.validation.constraints.Positive


@RestController
@RequestMapping("/brands")
@Validated
class BrandController(private val brandService: BrandService) {

    @GetMapping
    fun findAll(): BrandListView = brandService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<BrandDto> {
        return ResponseEntity.ok(brandService.findById(id))
    }

    @PostMapping
    fun save(
        @Valid @RequestBody brand: BrandDto,
        result: BindingResult
    ): ResponseEntity<BrandDto?> {
        checkBindingResultAndThrowExceptionIfInvalid(result);
        val saved = brandService.save(brand)
        val httpHeaders = HttpHeaders()
        if (saved != null) {
            httpHeaders.location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saved.id).toUri()
        }
        return ResponseEntity(saved, httpHeaders, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<*>? {
        brandService.delete(id)
        return ResponseEntity<Any>(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable
        @Positive(message = "Id must be positive!")
        id: Long,
        @Valid
        @RequestBody
        brand: BrandDto,
        result: BindingResult?
    ): ResponseEntity<BrandDto?> {
        checkBindingResultAndThrowExceptionIfInvalid(result!!)
        brand.id = id
        return ResponseEntity(
            brandService.update(brand),
            HttpStatus.OK
        )
    }
}