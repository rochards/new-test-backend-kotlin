package com.rochards.productcatalogmanagement.services.category

import com.rochards.productcatalogmanagement.domain.BusinessException
import com.rochards.productcatalogmanagement.domain.Category
import com.rochards.productcatalogmanagement.domain.ExceptionCode
import com.rochards.productcatalogmanagement.repositories.CategoryModel
import com.rochards.productcatalogmanagement.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryUpdateService(
    private val categoryRepository: CategoryRepository
) {

    fun execute(categoryId: String, category: Category) : Category {
        val categoryToUpdate = findCategory(categoryId)
        return updateCategory(category, categoryToUpdate)
    }

    private fun findCategory(categoryId: String): CategoryModel {
        return categoryRepository.findById(categoryId).orElseThrow {
            BusinessException(
                code = ExceptionCode.CATEGORY_NOT_FOUND,
                message = "category not found"
            )
        }
    }

    private fun updateCategory(category: Category, categoryToUpdate: CategoryModel): Category {
        if (category.title.isNotBlank())
            categoryToUpdate.title = category.title

        if (category.description.isNotBlank())
            categoryToUpdate.description = category.description

        if (category.ownerId.isNotBlank())
            categoryToUpdate.ownerId = category.ownerId

        categoryRepository.save(categoryToUpdate)

        return categoryToUpdate.toDomain()
    }
}