package by.chekun.dto.mapper

import by.chekun.dto.AbstractDto
import by.chekun.model.AbstractEntity


interface Mapper<E : AbstractEntity?, D : AbstractDto?> {
    fun toEntity(d: D): E?
    fun toDto(e: E): D?
    fun toDtoList(eList: List<E>): List<D?>
}