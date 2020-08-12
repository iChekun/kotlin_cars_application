package by.chekun.facade.impl

import by.chekun.bean.CarBean
import by.chekun.bean.CarRequestBean
import by.chekun.bean.PageWrapperBean
import by.chekun.bean.converter.impl.CarBeanDtoConverter
import by.chekun.bean.converter.impl.CarRequestBeanDtoConverter
import by.chekun.dto.CarSearchCriteria
import by.chekun.dto.Paging
import by.chekun.exception.ResourceNotFoundException
import by.chekun.facade.CarFacade
import by.chekun.service.BrandService
import by.chekun.service.CarService
import org.springframework.stereotype.Service


@Service
class CarFacadeImpl(
    private val carBeanDtoConverter: CarBeanDtoConverter,
    private val carRequestBeanDtoConverter: CarRequestBeanDtoConverter,
    private val carService: CarService,
    private val brandService: BrandService
) : CarFacade {

    override fun findAll(paging: Paging, searchCriteria: CarSearchCriteria): PageWrapperBean<CarBean> {

        val page = carService.findAll(paging, searchCriteria)

        return PageWrapperBean.of(
            carBeanDtoConverter.toBeanList(page.toList()),
            page.totalPages,
            page.totalElements,
            paging.page,
            page.numberOfElements
        )
    }


    override fun findById(id: Long): CarBean {
        if (!carService.isPresent(id)) {
            throw ResourceNotFoundException("Car with id $id does not exist!")
        }

        val car = this.carService.findById(id)

        return carBeanDtoConverter.toBean(car)
    }

    override fun save(carRequestBean: CarRequestBean): CarBean {
        if (!brandService.isPresent(carRequestBean.brandId)) {
            throw ResourceNotFoundException("Brand with id " + carRequestBean.brandId + " does not exist!")
        }

        val car = carRequestBeanDtoConverter.toDto(carRequestBean)
        return carBeanDtoConverter.toBean(carService.save(car))
    }

    override fun delete(id: Long) {
        if (!carService.isPresent(id)) {
            throw ResourceNotFoundException("Car with id $id does not exist!")
        }

        this.carService.delete(id)
    }

    override fun update(carRequestBean: CarRequestBean): CarBean {
        if (!carService.isPresent(carRequestBean.id)) {
            throw ResourceNotFoundException("Car with id " + carRequestBean.id + " does not exist!")
        }
        val updatedCar = carService.update(carRequestBeanDtoConverter.toDto(carRequestBean))

        return carBeanDtoConverter.toBean(updatedCar)
    }

}