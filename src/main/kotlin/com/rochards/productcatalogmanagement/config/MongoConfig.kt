package com.rochards.productcatalogmanagement.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongoConfig : AbstractMongoClientConfiguration() {

    @Value("\${spring.data.mongodb.uri}")
    private lateinit var mongoUri: String
    override fun getDatabaseName(): String = "product-catalog"

    override fun mongoClient(): MongoClient = MongoClients.create(mongoUri)
}