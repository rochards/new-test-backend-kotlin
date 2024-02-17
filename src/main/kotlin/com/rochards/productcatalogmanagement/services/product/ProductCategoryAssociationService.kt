package com.rochards.productcatalogmanagement.services.product

import com.rochards.productcatalogmanagement.domain.BusinessException
import com.rochards.productcatalogmanagement.domain.ExceptionCode
import com.rochards.productcatalogmanagement.domain.Product
import com.rochards.productcatalogmanagement.repositories.CategoryModel
import com.rochards.productcatalogmanagement.repositories.CategoryRepository
import com.rochards.productcatalogmanagement.repositories.ProductModel
import com.rochards.productcatalogmanagement.repositories.ProductRepository
import com.rochards.productcatalogmanagement.services.category.toDomain
import org.springframework.stereotype.Service

@Service
class ProductCategoryAssociationService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    fun execute(productId: String, categoryId: String): Product {
        val productToUpdate = findProduct(productId)
        val category = findCategory(categoryId)

        return updateProduct(productToUpdate, category)
    }

    private fun findProduct(productId: String): ProductModel {
        return productRepository.findById(productId).orElseThrow {
            BusinessException(
                code = ExceptionCode.PRODUCT_NOT_FOUND,
                message = "product not found"
            )
        }
    }

    private fun findCategory(categoryId: String): CategoryModel {
        return categoryRepository.findById(categoryId).orElseThrow {
            BusinessException(
                code = ExceptionCode.CATEGORY_NOT_FOUND,
                message = "category not found"
            )
        }
    }

    private fun updateProduct(productToUpdate: ProductModel, category: CategoryModel): Product {
        productToUpdate.categoryId = category.id
        productRepository.save(productToUpdate)

        return productToUpdate.toDomain(category.toDomain())
    }
}
