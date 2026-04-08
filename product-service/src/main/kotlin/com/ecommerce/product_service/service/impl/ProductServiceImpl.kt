package com.ecommerce.product_service.service.impl

import com.ecommerce.product_service.dto.ProductRequestDTO
import com.ecommerce.product_service.dto.ProductResponseDTO
import com.ecommerce.product_service.mapper.ProductMapper
import com.ecommerce.product_service.repository.ProductRepository
import com.ecommerce.product_service.service.ProductService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProductServiceImpl: ProductService {

    private final lateinit var productRepository: ProductRepository

    private final lateinit var mapper: ProductMapper

    override fun createProduct(requestDTO: ProductRequestDTO): ProductResponseDTO {

        val product = mapper.toProduct(requestDTO)

        val savedProduct = productRepository.save(product)

        return mapper.toProductResponseDTO(savedProduct)
    }

    override fun getAllsProducts(): List<ProductResponseDTO> =
        productRepository.findAll().map { mapper.toProductResponseDTO(it) }.toList()

    override fun getProductById(id: String): ProductResponseDTO? {

        val product = productRepository.findById(id)
            .orElseThrow { RuntimeException("Product with id $id not found") }

        return mapper.toProductResponseDTO(product)

    }

    override fun updateProduct(
        id: String,
        requestDTO: ProductRequestDTO
    ): ProductResponseDTO {
        val product = productRepository.findById(id)
            .orElseThrow { RuntimeException("Product with id $id not found") }

        mapper.updateProductFromRequest(requestDTO, product)

        val updatedProduct = productRepository.save(product)

        return mapper.toProductResponseDTO(updatedProduct)
    }

    override fun deleteProductById(id: String) {
        if (!productRepository.existsById(id)) throw RuntimeException("Product with id $id not found")
        productRepository.deleteById(id)
    }
}