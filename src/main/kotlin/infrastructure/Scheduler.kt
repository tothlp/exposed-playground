package hu.tothlp.infrastructure

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

object Scheduler {
	val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1)
}