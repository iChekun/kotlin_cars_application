package by.chekun.dto.mapper

import by.chekun.dto.AbstractDto
import by.chekun.model.AbstractEntity
import org.modelmapper.Converter
import org.modelmapper.ModelMapper
import org.modelmapper.spi.MappingContext
import org.springframework.beans.factory.annotation.Autowired
import java.util.*
import java.util.stream.Collectors

abstract class AbstractMapper<E : AbstractEntity?, D : AbstractDto?> internal constructor(
    private val entityClass: Class<E>,
    private val dtoClass: Class<D>
) :
    Mapper<E, D> {

    @Autowired
    private val mapper: ModelMapper? = null

    override fun toEntity(d: D): E? {
        return if (Objects.isNull(d)) null else mapper!!.map(d, entityClass)
    }

    override fun toDto(e: E): D? {
        return if (Objects.isNull(e)) null else mapper!!.map(e, dtoClass)
    }

    override fun toDtoList(eList: List<E>): List<D?> {
        return eList.stream()
            .map { entity: E -> toDto(entity) }
            .collect(Collectors.toList()).toList()
    }

    fun toDtoConverter(): Converter<E, D> {
        return Converter { context: MappingContext<E, D> ->
            val source = context.source
            val destination = context.destination
            mapSpecificFields(source, destination)
            context.destination
        }
    }

    fun toEntityConverter(): Converter<D, E> {
        return Converter { context: MappingContext<D, E> ->
            val source = context.source
            val destination = context.destination
            mapSpecificFields(source, destination)
            context.destination
        }
    }

    fun mapSpecificFields(source: E, destination: D) {}
    fun mapSpecificFields(source: D, destination: E) {}

}