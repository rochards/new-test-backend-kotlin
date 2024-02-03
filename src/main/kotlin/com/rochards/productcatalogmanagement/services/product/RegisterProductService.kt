package com.rochards.productcatalogmanagement.services.product

import com.rochards.productcatalogmanagement.domain.BusinessException
import com.rochards.productcatalogmanagement.domain.ExceptionCode
import com.rochards.productcatalogmanagement.domain.Product
import com.rochards.productcatalogmanagement.repositories.CategoryRepository
import com.rochards.productcatalogmanagement.repositories.ProductRepository
import com.rochards.productcatalogmanagement.services.category.toDomain
import org.springframework.stereotype.Service

@Service
class RegisterProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    fun execute(categoryId: String, product: Product): Product {
        val foundCategory = categoryRepository.findById(categoryId).orElseThrow {
            BusinessException(
                code = ExceptionCode.CATEGORY_NOT_FOUND,
                message = "category with id '$categoryId' not found"
            )
        }

        val savedProduct = productRepository.save(product.toModel(categoryId))
        return savedProduct.toDomain(foundCategory.toDomain())
    }
}