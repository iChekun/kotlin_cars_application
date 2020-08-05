package by.chekun.facade

import by.chekun.bean.BrandBean

interface BrandFacade {

    fun findAll(): List<BrandBean>

    fun findById(id: Long): BrandBean

    fun save(brandBean: BrandBean): BrandBean

    fun delete(id: Long)

    fun update(brandBean: BrandBean)

}