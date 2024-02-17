package com.rochards.productcatalogmanagement.controllers.product.v1

import com.rochards.productcatalogmanagement.services.product.ProductCategoryAssociationService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/products")
class ProductCategoryAssociationController(
    private val associationService: ProductCategoryAssociationService
) {

    @PatchMapping("/{productId}/categories")
    fun associateToCategory(
        @PathVariable("productId") @NotBlank @Size(max = 50) productId: String,
        @RequestBody @Valid category: CategoryAssociationRequest
    ): ResponseEntity<ProductResponse> {

        val updatedProduct = associationService.execute(productId, category.categoryId!!)
        return ResponseEntity.ok(updatedProduct.toResponse())
    }
}