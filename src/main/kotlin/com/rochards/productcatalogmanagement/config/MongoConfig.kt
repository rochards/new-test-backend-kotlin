package com.rochards.productcatalogmanagement.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongoConfig : AbstractMongoClientConfiguration() {
    override fun getDatabaseName(): String = "product-catalog"

    override fun mongoClient(): MongoClient = MongoClients.create("mongodb://localhost:27017")
}