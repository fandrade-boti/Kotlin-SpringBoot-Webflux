package com.template.demo.domain.status

enum class PurchaseOrderItemInternalStatus {
    CREATED,
    INTEGRATED_FAILED,
    INTEGRATED_ERP,
    PENDING,
    ON_HOLD,
    REJECTED,
    SCHEDULED,
    PARTIALLY_FULFILLED,
    FULFILLED,
    ERROR_CREATION,
    SYNC_ERP_DONE,
    CANCELED
}
