package com.alexeiaj.planningpokeraccount.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(scanBasePackages = ["com.alexeiaj.planningpokeraccount"])
@EnableMongoRepositories
class PlanningPokerAccountApplication

fun main(args: Array<String>) {
	runApplication<PlanningPokerAccountApplication>(*args)
}
