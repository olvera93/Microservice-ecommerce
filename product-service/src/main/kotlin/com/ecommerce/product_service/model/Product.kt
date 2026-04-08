package com.ecommerce.product_service.model

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document("product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
class Product {

    @Id
    private val id: String? = null

    private val name: String? = null

    private val description: String? = null

    private val price: BigDecimal? = null

}