package com.rochards.productcatalogmanagement.services.category

import com.rochards.productcatalogmanagement.domain.Category
import com.rochards.productcatalogmanagement.repositories.CategoryModel


fun Category.toModel(): CategoryModel {
    return CategoryModel(
        title = this.title,
        description =  this.description,
        ownerId = this.ownerId
    )
}

fun CategoryModel.toDomain(): Category {
    return Category(
        id = this.id,
        description = this.description,
        title = this.title,
        ownerId = this.ownerId
    )
}