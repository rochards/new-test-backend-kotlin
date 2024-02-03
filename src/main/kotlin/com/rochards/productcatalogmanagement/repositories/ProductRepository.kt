package com.rochards.productcatalogmanagement.repositories

import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<ProductModel, String>