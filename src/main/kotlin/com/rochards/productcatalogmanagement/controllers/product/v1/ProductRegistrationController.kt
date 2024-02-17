package com.rochards.productcatalogmanagement.controllers.product.v1

import com.rochards.productcatalogmanagement.services.product.ProductRegistrationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/products")
class ProductRegistrationController(
    private val productRegistrationService: ProductRegistrationService
) {

    @PostMapping
    fun registerProduct(@RequestBody @Valid product: ProductRequest): ResponseEntity<ProductResponse> {
        val savedProduct = productRegistrationService.execute(product.toDomain())
        return ResponseEntity
            .created(URI.create("/api/v1/products/${savedProduct.id}"))
            .body(savedProduct.toResponse())
    }
}