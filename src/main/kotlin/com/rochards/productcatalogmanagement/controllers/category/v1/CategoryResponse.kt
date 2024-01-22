package com.rochards.productcatalogmanagement.controllers.category.v1

data class CategoryResponse(
    val id: String,
    val title: String,
    val description: String,
    val ownerId: String
)
