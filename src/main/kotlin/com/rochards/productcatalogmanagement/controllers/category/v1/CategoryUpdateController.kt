package com.rochards.productcatalogmanagement.controllers.category.v1

import com.rochards.productcatalogmanagement.services.category.CategoryUpdateService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/categories")
class CategoryUpdateController(
    private val categoryUpdateService: CategoryUpdateService
) {

    @PutMapping("{categoryId}")
    fun updateCategory(
        @PathVariable @NotBlank @Size(max = 50) categoryId: String,
        @RequestBody @Valid category: CategoryUpdateRequest
    ): ResponseEntity<CategoryResponse> {
        val updatedCategory = categoryUpdateService.execute(categoryId, category.toDomain())
        return ResponseEntity.ok(updatedCategory.toResponse())
    }
}