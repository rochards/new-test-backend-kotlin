package com.rochards.productcatalogmanagement.domain

data class Category(
    val id: String? = null,
    val title: String,
    val description: String,
    val ownerId: String
)