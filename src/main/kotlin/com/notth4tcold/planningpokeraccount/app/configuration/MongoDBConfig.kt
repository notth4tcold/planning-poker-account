package com.notth4tcold.planningpokeraccount.app.configuration

import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration


@Configuration
class MongoDBConfig: AbstractMongoClientConfiguration() {

    @Value("\${spring.data.mongodb.username}")
    var username: String? = null

    @Value("\${spring.data.mongodb.password}")
    var password: String? = null

    @Value("\${spring.data.mongodb.host}")
    var host: String? = null

    override fun getDatabaseName() = "planning-poker-account"
    override fun mongoClient() = MongoClients.create("mongodb://$username:$password@$host:27017/planning-poker-account?authSource=admin")
}