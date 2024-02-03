package com.rochards.productcatalogmanagement.controllers.product.v1

import com.rochards.productcatalogmanagement.controllers.category.v1.CategoryResponse
import com.rochards.productcatalogmanagement.domain.Product

fun ProductRequest.toDomain(): Product {
    return Product(
        title = this.title!!,
        description = this.description!!,
        price = this.price!!,
        ownerId = this.ownerId!!
    )
}

fun Product.toResponse(): ProductResponse {
    return ProductResponse(
        id = this.id!!,
        title = this.title,
        description = this.description,
        price = this.price,
        ownerId = this.ownerId,
        category = CategoryResponse(
            id = this.category!!.id!!,
            title = this.category.title,
            description = this.category.description,
            ownerId = this.category.ownerId
        )
    )
}