package by.chekun.facade

import by.chekun.bean.CarBean
import by.chekun.bean.CarCreateBean
import by.chekun.bean.PageWrapperBean
import by.chekun.dto.CarSearchCriteria
import by.chekun.dto.Paging

interface CarFacade {

    fun findAll(paging: Paging, searchCriteria: CarSearchCriteria): PageWrapperBean<CarBean>

    fun findById(id: Long): CarBean

    fun save(carCreateBean: CarCreateBean): CarBean

    fun delete(id: Long)

    fun update(carBean: CarBean)

}