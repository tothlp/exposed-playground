package hu.tothlp.data

import hu.tothlp.core.model.CoffeeModel
import hu.tothlp.data.Coffees.id
import hu.tothlp.data.Coffees.name
import hu.tothlp.data.Coffees.roaster
import hu.tothlp.infrastructure.transactionWithLogging
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class CoffeeRepository {

	init { transactionWithLogging {

		if(findAll().isEmpty()) {
			Coffees.insert {
				it[name] = "Ethiopia Guji"
				it[roaster] = "Awaken"
			}
			Coffees.insert {
				it[name] = "Costa Rica"
				it[roaster] = "Awaken"
			}
			Coffees.insert {
				it[name] = "Colombia"
				it[roaster] = "Awaken"
			}
		}
	}
	}

	// Implement the getAll function, which returns a list of CoffeeModel
	fun findAll(): List<CoffeeModel> = transactionWithLogging {
		return@transactionWithLogging Coffees.selectAll().map { it.toCoffee() }
	}

	// Implement the toCoffee extension function, which maps the result row to a CoffeeModel
	private fun ResultRow.toCoffee() = CoffeeModel(this[id].value, this[name], this[roaster])

}