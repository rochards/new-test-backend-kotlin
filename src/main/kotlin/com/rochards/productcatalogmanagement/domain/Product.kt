package com.rochards.productcatalogmanagement.domain

import java.math.BigDecimal

data class Product(
    val id: String? = null,
    val title: String,
    val description: String,
    val price: BigDecimal,
    val ownerId: String,
    val category: Category? = null
)