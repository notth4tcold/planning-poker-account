package com.notth4tcold.kotlin-app.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(scanBasePackages = ["com.notth4tcold.kotlin-app"])
@EnableMongoRepositories
class kotlin-appApplication

fun main(args: Array<String>) {
	runApplication<kotlin-appApplication>(*args)
}
