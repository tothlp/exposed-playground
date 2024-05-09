plugins {
	kotlin("jvm") version "1.9.23"
}

group = "hu.tothlp"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}
val exposedVersion = "0.50.0"

dependencies {

	implementation("org.jetbrains.exposed", "exposed-core", exposedVersion)
	implementation("org.jetbrains.exposed", "exposed-dao", exposedVersion)
	implementation("org.jetbrains.exposed", "exposed-jdbc", exposedVersion)
	implementation("org.xerial:sqlite-jdbc:3.45.3.0")
	implementation("com.zaxxer:HikariCP:4.0.3")
	// Add the latest version of logback-classic
	implementation("ch.qos.logback:logback-classic:1.5.6")
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(17)
}