package com.template.demo.application

import com.template.demo.domain.model.PurchaseOrderService
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrderReactiveRepository
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrderReactiveRepositoryImpl
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PurchaseOrderServiceReactiveImpl(
    private val purchaseOrderRepositoryImpl: PurchaseOrderReactiveRepositoryImpl,
    private val purchaseOrderRepository: PurchaseOrderReactiveRepository
) : PurchaseOrderService {

    override fun insert(purchaseOrder: PurchaseOrder): Mono<Long?>? {
        return purchaseOrderRepositoryImpl.insert(purchaseOrder)
    }

    override fun findById(id: Long): Mono<PurchaseOrder> {
        return purchaseOrderRepository.findById(id)
    }
}