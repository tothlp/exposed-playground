package hu.tothlp.infrastructure

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.ConsoleAppender
import org.slf4j.LoggerFactory

object LoggerConfigurer {
	fun configureLogback() {
		val loggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
		loggerContext.reset() // reset previous configuration

		val patternLayoutEncoder = PatternLayoutEncoder()
		patternLayoutEncoder.context = loggerContext
		patternLayoutEncoder.pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
		patternLayoutEncoder.start()

		val consoleAppender = ConsoleAppender<ILoggingEvent>()
		consoleAppender.context = loggerContext
		consoleAppender.encoder = patternLayoutEncoder
		consoleAppender.start()

		val rootLogger = loggerContext.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME)
		rootLogger.level = Level.INFO
		rootLogger.addAppender(consoleAppender)
	}
}