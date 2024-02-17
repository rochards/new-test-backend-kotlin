package com.rochards.productcatalogmanagement.services.product

import com.rochards.productcatalogmanagement.domain.Product
import com.rochards.productcatalogmanagement.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class RegisterProductService(
    private val productRepository: ProductRepository
) {
    fun execute(product: Product): Product {
        val savedProduct = productRepository.save(product.toModel())
        return savedProduct.toDomain()
    }
}