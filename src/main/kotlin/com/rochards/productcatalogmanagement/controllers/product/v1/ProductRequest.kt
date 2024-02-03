package com.rochards.productcatalogmanagement.controllers.product.v1

import com.rochards.productcatalogmanagement.controllers.validations.UUID
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.math.BigDecimal

data class ProductRequest(
    @field:[NotBlank Size(max = 50)] val title: String?,
    @field:[NotBlank Size(max = 100)] val description: String?,
    @field:Min(0) val price: BigDecimal?,
    @field:UUID val ownerId: String?,
    @field:[NotBlank Size(min = 24, max = 24)] val categoryId: String?
)
