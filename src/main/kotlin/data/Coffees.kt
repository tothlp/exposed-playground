package hu.tothlp.data

import org.jetbrains.exposed.dao.id.IntIdTable

object Coffees: IntIdTable() {
	val name = varchar("name", 50)
	val roaster = varchar("roaster", 50)
}