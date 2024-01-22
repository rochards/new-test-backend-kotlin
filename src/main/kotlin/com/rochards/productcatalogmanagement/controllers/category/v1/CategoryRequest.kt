package com.rochards.productcatalogmanagement.controllers.category.v1

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoryRequest(
    @field:[NotBlank Size(max = 100)] val title: String?,
    @field:[NotBlank Size(max = 100)] val description: String?,
    @field:[NotBlank] val ownerId: String?
)
