package com.rochards.productcatalogmanagement.controllers.category.v1

import com.rochards.productcatalogmanagement.controllers.validations.UUID
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoryRequest(
    @field:[NotBlank Size(max = 100)] val title: String?,
    @field:[NotBlank Size(max = 100)] val description: String?,
    @field:[NotBlank UUID] val ownerId: String?
)
