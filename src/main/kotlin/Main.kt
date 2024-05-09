package hu.tothlp

import hu.tothlp.infrastructure.Beans.coffeeService
import hu.tothlp.infrastructure.DbSettings.initDatabase
import hu.tothlp.infrastructure.LoggerConfigurer.configureLogback
import hu.tothlp.infrastructure.Scheduler.scheduler
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
	configureLogback()
	//an example connection to H2 DB
	initDatabase()

	scheduler.scheduleAtFixedRate(coffeeService, 0, 5, TimeUnit.SECONDS)

}