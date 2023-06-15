package com.template.demo.application

import com.template.demo.domain.model.PurchaseOrderService
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrderRepository
import org.springframework.stereotype.Service

@Service
class PurchaseOrderServiceImpl(
    private val purchaseOrderRepository: PurchaseOrderRepository
) : PurchaseOrderService {

    override fun save(purchaseOrder: PurchaseOrder){
        purchaseOrderRepository.save(purchaseOrder)
    }
}