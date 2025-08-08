package com.notth4tcold.planningpokeraccount.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(scanBasePackages = ["com.notth4tcold.planningpokeraccount"])
@EnableMongoRepositories
class PlanningPokerAccountApplication

fun main(args: Array<String>) {
	runApplication<PlanningPokerAccountApplication>(*args)
}
