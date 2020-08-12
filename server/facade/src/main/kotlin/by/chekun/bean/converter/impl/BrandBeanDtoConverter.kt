package by.chekun.bean.converter.impl

import by.chekun.bean.BrandBean
import by.chekun.bean.converter.Converter
import by.chekun.dto.BrandDto
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class BrandBeanDtoConverter :
    Converter<BrandBean, BrandDto> {

    override fun toDto(b: BrandBean): BrandDto {
        val brand = BrandDto()
        brand.id = b.id
        brand.title = b.title
        return brand
    }

    override fun toBean(d: BrandDto): BrandBean {
        val brand = BrandBean()
        brand.id = d.id
        brand.title = d.title
        return brand
    }

    override fun toBeanList(eList: List<BrandDto>): List<BrandBean> {
        return eList.stream().map { e -> toBean(e) }.collect(Collectors.toList())
    }

}