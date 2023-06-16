package com.template.demo.infrastructure.persistence.configuration

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.ReactiveTransactionManager


@Configuration
class FlywayR2DBCConfiguration(private val dataSourceProperties: DataSourceProperties) {

    @Bean(initMethod = "migrate")
    fun flyway(transactionManager: ReactiveTransactionManager): Flyway {
        val flyway = Flyway.configure()
            .locations("classpath:db/migration")
            .dataSource(dataSourceProperties.url, dataSourceProperties.username, dataSourceProperties.password)
            .load()
        flyway.migrate()
        return flyway
    }

}