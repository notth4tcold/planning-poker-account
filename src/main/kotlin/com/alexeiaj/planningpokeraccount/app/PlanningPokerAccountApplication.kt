package com.alexeiaj.planningpokeraccount.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.alexeiaj.planningpokeraccount"])
class PlanningPokerAccountApplication

fun main(args: Array<String>) {
	runApplication<PlanningPokerAccountApplication>(*args)
}
