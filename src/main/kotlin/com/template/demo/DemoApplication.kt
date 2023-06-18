package com.template.demo

import com.template.demo.infrastructure.persistence.configuration.FlywayR2DBCConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import reactor.netty.http.server.HttpServer
import reactor.netty.resources.LoopResources


@EnableAutoConfiguration
@SpringBootApplication(exclude = [FlywayR2DBCConfiguration::class])
@Import(FlywayR2DBCConfiguration::class)
class DemoApplication





fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
