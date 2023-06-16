package com.template.demo.infrastructure.persistence.purchaseorder

import com.template.demo.infrastructure.persistence.configuration.PostgresqlR2DBCDatabaseConfiguration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono


@Repository
class  PurchaseOrderReactiveRepositoryImpl {

    val databaseClient = DatabaseClient.create(PostgresqlR2DBCDatabaseConfiguration().connectionFactory())

    fun insert(purchaseOrder: PurchaseOrder): Mono<Long?>? {

        return databaseClient.execute("INSERT INTO purchase_order (store_code, status, status_internal, business_unit, erp, created_at, updated_at) VALUES ($1, $2, $3, $4, $5, $6, $7) RETURNING id")
            .bind("$1", purchaseOrder.storeCode)
            .bind("$2", purchaseOrder.status)
            .bind("$3", purchaseOrder.statusInternal)
            .bind("$4", purchaseOrder.businessUnit)
            .bind("$5", purchaseOrder.erp.toString())
            .bind("$6", purchaseOrder.createdAt)
            .bind("$7", purchaseOrder.updatedAt)
            .map {
                    row -> row.get("id") as Long
            }.first()
    }
}