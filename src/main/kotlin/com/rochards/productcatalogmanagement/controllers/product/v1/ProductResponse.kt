package com.rochards.productcatalogmanagement.controllers.product.v1

import com.rochards.productcatalogmanagement.controllers.category.v1.CategoryResponse
import java.math.BigDecimal

data class ProductResponse(
    val id: String,
    val title: String,
    val description: String,
    val price: BigDecimal,
    val ownerId: String,
    val category: CategoryResponse
)
