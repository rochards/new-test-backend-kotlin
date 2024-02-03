package com.rochards.productcatalogmanagement.controllers.category.v1

import com.rochards.productcatalogmanagement.domain.Category

fun CategoryRequest.toDomain(): Category {
    return Category(
        title = this.title!!,
        description = this.description!!,
        ownerId = this.ownerId!!
    )
}

fun Category.toResponse(): CategoryResponse {
    return CategoryResponse(
        id = this.id!!,
        title = this.title,
        description = this.description,
        ownerId = this.ownerId
    )
}