package hu.tothlp.infrastructure

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import hu.tothlp.data.Coffees
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DbSettings {
	fun initDatabase() {
		db
		transactionWithLogging {
			SchemaUtils.create (Coffees)
		}
	}
	val db by lazy {
		val config = HikariConfig().apply {
			jdbcUrl = "jdbc:sqlite:sample.db"
//			driverClassName = "com.mysql.cj.jdbc.Driver"
//			username = "username"
//			password = "password"
			maximumPoolSize = 6
			// as of version 0.46.0, if these options are set here, they do not need to be duplicated in DatabaseConfig
			isReadOnly = false
			transactionIsolation = "TRANSACTION_SERIALIZABLE"
		}

		val dataSource = HikariDataSource(config)

		Database.connect(dataSource)
	}
}

fun <T> transactionWithLogging(statement: Transaction.() -> T): T {
	return transaction() {
		addLogger(StdOutSqlLogger)
		statement.invoke(this)
	}
}