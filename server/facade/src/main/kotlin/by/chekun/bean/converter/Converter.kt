package by.chekun.bean.converter

import by.chekun.dto.AbstractDto
import by.chekun.bean.AbstractBean


interface Converter<B : AbstractBean?, D : AbstractDto?> {

    fun toDto(b: B): D

    fun toBean(d: D): B

    fun toBeanList(eList: List<D>): List<B>
}