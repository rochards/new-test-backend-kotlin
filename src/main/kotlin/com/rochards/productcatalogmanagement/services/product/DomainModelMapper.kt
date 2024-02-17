package com.rochards.productcatalogmanagement.services.product

import com.rochards.productcatalogmanagement.domain.Category
import com.rochards.productcatalogmanagement.domain.Product
import com.rochards.productcatalogmanagement.repositories.ProductModel

fun Product.toModel(categoryId: String? = null): ProductModel {
    return ProductModel(
        title = this.title,
        description = this.description,
        ownerId = this.ownerId,
        price = this.price,
        categoryId = categoryId
    )
}

fun ProductModel.toDomain(category: Category? = null): Product {
    return Product(
        id = this.id,
        title = this.title,
        description = this.description,
        price = this.price,
        ownerId = this.ownerId,
        category = category
    )
}