package com.template.demo

import com.template.demo.infrastructure.persistence.configuration.FlywayR2DBCConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@EnableAutoConfiguration
@SpringBootApplication(exclude = [FlywayR2DBCConfiguration::class])
@Import(FlywayR2DBCConfiguration::class)
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
