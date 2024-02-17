package com.rochards.productcatalogmanagement.repositories

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "products")
data class ProductModel(
    @Id
    val id: String? = null,
    val title: String,
    val description: String,
    val price: BigDecimal,
    val ownerId: String,
    var categoryId: String?
)
