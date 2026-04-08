package com.ecommerce.product_service.dto

import java.math.BigDecimal

data class ProductResponseDTO(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val price: BigDecimal? = null
)
