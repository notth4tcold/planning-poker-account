package com.alexeiaj.planningpokeraccount.app

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableEncryptableProperties
@SpringBootApplication(scanBasePackages = ["com.alexeiaj.planningpokeraccount"])
@EnableMongoRepositories
class PlanningPokerAccountApplication

fun main(args: Array<String>) {
	runApplication<PlanningPokerAccountApplication>(*args)
}
