package com.rochards.productcatalogmanagement.controllers.product.v1

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CategoryAssociationRequest(
    @field:[NotBlank Size(max = 50)] val categoryId: String?
)
