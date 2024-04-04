import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive:3.1.2")
	implementation("io.projectreactor:reactor-core:3.6.4")
	implementation("org.springframework.boot:spring-boot-starter-webflux:3.1.2")
	implementation(project(":task-submodule"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive:3.1.2")
		implementation("io.projectreactor:reactor-core:3.6.4")
		implementation("org.springframework.boot:spring-boot-starter-webflux:3.1.2")
	}

	group = "com.example"
	version = "0.0.1-SNAPSHOT"

	kotlin {
		jvmToolchain(21)
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	springBoot {
		mainClass = "com.example.TaskManagerApplication.kt"
	}
}
