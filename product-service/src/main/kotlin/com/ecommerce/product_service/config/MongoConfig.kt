package com.ecommerce.product_service.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
class MongoConfig: AbstractMongoClientConfiguration() {

    @Value($$"${spring.data.mongodb.host}")
    private val host: String = ""

    @Value($$"${spring.data.mongodb.port}")
    private val port: Int = 0

    @Value($$"${spring.data.mongodb.database}")
    private val database: String = ""

    @Value($$"${spring.data.mongodb.username}")
    private val username: String = ""

    @Value($$"${spring.data.mongodb.password}")
    private val password: String = ""

    @Value($$"${spring.data.mongodb.authentication-database}")
    private val autDatabase: String = ""


    override fun getDatabaseName(): String {
        return "product-db"
    }

    @Bean
    override fun mongoClient(): MongoClient {
        val credential: MongoCredential = MongoCredential.createCredential(
            username, autDatabase, password.toCharArray()
        )

        val connectionString = String.format("mongodb://%s:%d", host, port)

        val settings: MongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(connectionString))
            .credential(credential)
            .build()

        return MongoClients.create(settings)

    }
}