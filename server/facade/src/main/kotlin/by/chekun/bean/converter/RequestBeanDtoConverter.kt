package by.chekun.bean.converter

interface RequestBeanDtoConverter<B, D> {

    fun toDto(b: B): D

}