package com.rochards.productcatalogmanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class ProductCatalogManagementApplication

fun main(args: Array<String>) {
	runApplication<ProductCatalogManagementApplication>(*args)
}
