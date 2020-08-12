package by.chekun.controller

import by.chekun.bean.BrandBean
import by.chekun.controller.ControllerHelper.checkBindingResultAndThrowExceptionIfInvalid
import by.chekun.facade.BrandFacade
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
class BrandController(private val brandFacade: BrandFacade) {

    @GetMapping
    fun findAll(): List<BrandBean> = brandFacade.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<BrandBean> {
        return ResponseEntity.ok(brandFacade.findById(id))
    }

    @PostMapping
    fun save(
        @Valid @RequestBody brand: BrandBean,
        result: BindingResult
    ): ResponseEntity<BrandBean> {
        checkBindingResultAndThrowExceptionIfInvalid(result);
        val saved = brandFacade.save(brand)
        val httpHeaders = HttpHeaders()
        httpHeaders.location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(saved.id).toUri()
        return ResponseEntity(saved, httpHeaders, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<*>? {
        brandFacade.delete(id)
        return ResponseEntity<Any>(HttpStatus.NO_CONTENT)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable
        @Positive(message = "Id must be positive!")
        id: Long,
        @Valid
        @RequestBody
        brand: BrandBean,
        result: BindingResult?
    ): ResponseEntity<BrandBean> {
        checkBindingResultAndThrowExceptionIfInvalid(result!!)
        brand.id = id
        return ResponseEntity(
            brandFacade.update(brand),
            HttpStatus.OK
        )
    }
}