package com.alexeiaj.planningpokeraccount.app.configuration

import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration


@Configuration
class MongoDBConfig: AbstractMongoClientConfiguration() {
    override fun getDatabaseName() = "planning-poker-account"
    override fun mongoClient() = MongoClients.create("mongodb://mongouser:mongopassword@mongo:27017/planning-poker-account?authSource=admin")
}