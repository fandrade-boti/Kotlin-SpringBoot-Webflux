package com.template.demo.domain.model

import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder
import reactor.core.publisher.Mono

interface PurchaseOrderService {

    fun insert(purchaseOrder: PurchaseOrder): Mono<Long?>?

    fun findById(id: Long): Mono<PurchaseOrder>
}