package hu.tothlp.core

import hu.tothlp.data.CoffeeRepository

class CoffeeService(
	private val coffeeRepository: CoffeeRepository
): Runnable {
	override fun run() {
		coffeeRepository.findAll().forEach { println(it) }
	}
}