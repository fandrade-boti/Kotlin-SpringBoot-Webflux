import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.12"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	kotlin("plugin.jpa") version "1.8.21"
	id("org.flywaydb.flyway") version "9.19.3"
}

group = "com.template"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web") {

		exclude (group = "org.springframework.boot" , module = "spring-boot-starter-tomcat")
	}

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.flywaydb:flyway-core:9.16.0")
	implementation("com.vladmihalcea:hibernate-types-52:2.21.1")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation ("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE" )
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")

	implementation("org.postgresql:postgresql:42.5.4")

	implementation ("org.springframework.boot:spring-boot-starter-webflux")
	implementation ("io.projectreactor:reactor-core")
	implementation ("io.netty:netty-all")



	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.amqp:spring-rabbit-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
