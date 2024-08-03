import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"

	val kotlinVersion = "2.0.0"
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

allprojects {
	group = "com.vssekorin"
	version = "0.1"

	repositories {
		mavenCentral()
		maven(url = "https://jitpack.io")
	}
}

subprojects {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")

	dependencies {
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<KotlinCompile> {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}
	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

tasks.withType<BootJar> {
	enabled = false
}
