package com.template.demo.domain.model

import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder

interface PurchaseOrderService {

    fun save(purchaseOrder: PurchaseOrder)
}