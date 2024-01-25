package com.rochards.productcatalogmanagement.repositories

import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryRepository : MongoRepository<CategoryModel, String>