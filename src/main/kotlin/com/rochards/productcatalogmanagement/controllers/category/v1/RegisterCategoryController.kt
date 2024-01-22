package com.rochards.productcatalogmanagement.controllers.category.v1

import com.rochards.productcatalogmanagement.services.category.Category
import com.rochards.productcatalogmanagement.services.category.RegisterCategoryService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/categories")
class RegisterCategoryController(
    private val registerCategoryService: RegisterCategoryService
) {
    @PostMapping
    fun registerCategory(@RequestBody @Valid category: CategoryRequest): ResponseEntity<CategoryResponse> {
        val savedCategory = registerCategoryService.execute(category.toEntity())
        return ResponseEntity
            .created(URI.create("/api/v1/categories/${savedCategory.id}"))
            .body(savedCategory.toResponse())
    }
}

fun CategoryRequest.toEntity(): Category {
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