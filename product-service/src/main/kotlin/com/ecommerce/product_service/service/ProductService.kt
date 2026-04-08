package com.ecommerce.product_service.service

import com.ecommerce.product_service.dto.ProductRequestDTO
import com.ecommerce.product_service.dto.ProductResponseDTO

interface ProductService {

    fun createProduct(requestDTO: ProductRequestDTO): ProductResponseDTO

    fun getAllsProducts(): List<ProductResponseDTO>

    fun getProductById(id: String): ProductResponseDTO?

    fun updateProduct(id: String, requestDTO: ProductRequestDTO): ProductResponseDTO

    fun deleteProductById(id: String)

}