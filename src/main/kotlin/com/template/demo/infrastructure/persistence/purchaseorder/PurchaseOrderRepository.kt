package com.template.demo.infrastructure.persistence.purchaseorder

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  PurchaseOrderRepository: JpaRepository<PurchaseOrder, Long> {
}