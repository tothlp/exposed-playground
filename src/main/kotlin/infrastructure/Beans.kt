package hu.tothlp.infrastructure

import hu.tothlp.core.CoffeeService
import hu.tothlp.data.CoffeeRepository

object Beans {
	val coffeeRepository = CoffeeRepository()
	val coffeeService = CoffeeService(coffeeRepository)

}