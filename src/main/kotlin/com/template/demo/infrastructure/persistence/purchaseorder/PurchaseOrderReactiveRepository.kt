package com.template.demo.infrastructure.persistence.purchaseorder

import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono


@Repository
interface  PurchaseOrderReactiveRepository: R2dbcRepository<PurchaseOrder, Long> {


}