package by.chekun.dto.converter

import by.chekun.dto.BrandDto
import by.chekun.model.Brand
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class BrandEntityDtoConverter : Converter<BrandDto, Brand> {

    override fun toEntity(d: BrandDto): Brand {
        val brand = Brand()
        brand.id = d.id
        brand.title = d.title
        return brand
    }

    override fun toDto(e: Brand): BrandDto {
        val brandDto = BrandDto()
        brandDto.id = e.id
        brandDto.title = e.title
        return brandDto
    }

    override fun toDtoList(eList: List<Brand>): List<BrandDto> {
        return eList.stream().map { e -> toDto(e) }.collect(Collectors.toList())
    }

}