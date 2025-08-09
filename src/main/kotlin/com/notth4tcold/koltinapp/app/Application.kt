package com.notth4tcold.kotlinapp.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(scanBasePackages = ["com.notth4tcold.kotlinapp"])
@EnableMongoRepositories
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
