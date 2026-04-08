package com.ecommerce.product_service.mapper

import com.ecommerce.product_service.dto.ProductRequestDTO
import com.ecommerce.product_service.dto.ProductResponseDTO
import com.ecommerce.product_service.model.Product
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring")
interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    fun toProduct(requestDTO: ProductRequestDTO): Product

    fun toProductResponseDTO(product: Product): ProductResponseDTO

    @Mapping(target = "id", ignore = true)
    fun updateProductFromRequest(
        productRequest: ProductRequestDTO,
        @MappingTarget product: Product)

}