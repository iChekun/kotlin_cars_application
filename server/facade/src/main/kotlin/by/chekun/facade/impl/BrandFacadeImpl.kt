package by.chekun.facade.impl

import by.chekun.bean.BrandBean
import by.chekun.bean.converter.impl.BrandBeanDtoConverter
import by.chekun.exception.ResourceNotFoundException
import by.chekun.facade.BrandFacade
import by.chekun.service.BrandService
import org.springframework.stereotype.Service

@Service
class BrandFacadeImpl(
    private val brandBeanDtoConverter: BrandBeanDtoConverter,
    private val brandService: BrandService
) : BrandFacade {

    override fun findAll(): List<BrandBean> {
        val brands = brandService.findAll()

        return brandBeanDtoConverter.toBeanList(brands)
    }

    override fun findById(id: Long): BrandBean {
        if (!brandService.isPresent(id)) {
            throw ResourceNotFoundException("Brand with id $id does not exist!")
        }

        val brand = brandService.findById(id)
        return brandBeanDtoConverter.toBean(brand)
    }

    override fun save(brandBean: BrandBean): BrandBean {
        val brand = brandBeanDtoConverter.toDto(brandBean)
        return brandBeanDtoConverter.toBean(brandService.save(brand))
    }

    override fun delete(id: Long) {
        if (!brandService.isPresent(id)) {
            throw ResourceNotFoundException("Brand with id $id does not exist!")
        }

        brandService.delete(id)
    }

    override fun update(brandBean: BrandBean): BrandBean {
        if (!brandService.isPresent(brandBean.id)) {
            throw ResourceNotFoundException("Brand with id " + brandBean.id + " does not exist !")
        }

        val updatedBrand = brandService.update(brandBeanDtoConverter.toDto(brandBean))

        return brandBeanDtoConverter.toBean(updatedBrand)
    }
}