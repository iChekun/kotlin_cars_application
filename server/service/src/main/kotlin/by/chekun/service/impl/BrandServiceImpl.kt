package by.chekun.service.impl

import by.chekun.dto.car.brand.BrandDto
import by.chekun.dto.car.brand.BrandListView
import by.chekun.dto.mapper.impl.BrandMapper
import by.chekun.exception.ResourceAttributeConflictException
import by.chekun.exception.ResourceNotFoundException
import by.chekun.model.brand.Brand
import by.chekun.repository.brand.BrandRepository
import by.chekun.service.BrandService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class BrandServiceImpl(
    private val brandMapper: BrandMapper,
    private val brandRepository: BrandRepository
) : BrandService {

    @Transactional(readOnly = true)
    override fun findAll(): BrandListView {
        val brands: List<Brand> = brandRepository.findAll()

        return BrandListView(brandMapper.toDtoList(brands))
    }

    @Transactional(readOnly = true)
    override fun findById(id: Long): BrandDto? {
        val brand: Brand = this.brandRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Brand with id $id not found!") }
        return this.brandMapper.toDto(brand)
    }

    @Transactional
    override fun save(brandDto: BrandDto): BrandDto? {
        if (brandRepository.findByTitle(brandDto.title).isPresent) {
            throw ResourceAttributeConflictException("Brand with title " + brandDto.title + "is already present! Choose another title please")
        }

        val brand: Brand? = this.brandMapper.toEntity(brandDto)
        return this.brandMapper.toDto(brandRepository.save(brand)!!)
    }

    @Transactional
    override fun delete(id: Long) {
        val brand: Brand = this.brandRepository.findById(id)
            .orElseThrow { throw ResourceNotFoundException("Brand with id $id not found!") }
        brandRepository.delete(brand)
    }

    @Transactional
    override fun update(brandDto: BrandDto): BrandDto? {
        this.brandRepository.findById(
            brandDto.id
        ).orElseThrow { throw ResourceNotFoundException("Brand with id " + brandDto.id + " not found!") }

        val updatedBrand = brandRepository.save(brandMapper.toEntity(brandDto))

        return brandMapper.toDto(updatedBrand!!)
    }

    @Transactional(readOnly = true)
    override fun isPresent(id: Long): Boolean {
        return brandRepository.findById(id).isPresent
    }

}