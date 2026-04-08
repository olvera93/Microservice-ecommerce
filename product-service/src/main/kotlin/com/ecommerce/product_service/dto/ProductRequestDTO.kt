package com.ecommerce.product_service.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class ProductRequestDTO(

    @NotBlank(message = "Product name can't be empty")
    val name: String? = null,

    val description: String? = null,

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be more than zero")
    val price: BigDecimal? = null
)
