package com.rochards.productcatalogmanagement.services.category

import com.rochards.productcatalogmanagement.domain.Category
import com.rochards.productcatalogmanagement.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class RegisterCategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun execute(category: Category): Category {
        val savedCategory = categoryRepository.save(category.toModel())
        return savedCategory.toDomain()
    }
}