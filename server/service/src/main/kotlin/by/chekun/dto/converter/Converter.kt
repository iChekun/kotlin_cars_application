package by.chekun.dto.converter

import by.chekun.dto.AbstractDto
import by.chekun.model.AbstractEntity


interface Converter<D : AbstractDto?, E : AbstractEntity?> {

    fun toEntity(d: D): E

    fun toDto(e: E): D

    fun toDtoList(eList: List<E>): List<D>
}