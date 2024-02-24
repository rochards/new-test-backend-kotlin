package com.rochards.productcatalogmanagement.controllers.category.v1

import com.rochards.productcatalogmanagement.controllers.validations.UUID
import com.rochards.productcatalogmanagement.controllers.validations.CategoryUpdateValidation
import jakarta.validation.constraints.Size

@CategoryUpdateValidation
data class CategoryUpdateRequest(
    @field:Size(max = 100) val title: String?,
    @field:Size(max = 100) val description: String?,
    @field:UUID val ownerId: String?
)
