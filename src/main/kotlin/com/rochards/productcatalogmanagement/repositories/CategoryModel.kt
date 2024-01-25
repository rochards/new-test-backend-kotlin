package com.rochards.productcatalogmanagement.repositories

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "categories")
data class CategoryModel(
    @Id
    val id: String? = null,
    val title: String,
    val description: String,
    val ownerId: String
)
