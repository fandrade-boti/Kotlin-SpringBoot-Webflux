package com.template.demo.domain.status

enum class PurchaseOrderItemStatus {
    OPEN,
    CLOSED,
    CREATED,
    INTEGRATED_FAILED,
    INTEGRATED_ERP,
    PENDING,
    REFUSED,
    PARTIALLY_FULFILLED,
    FULFILLED,
    ERROR_VALIDATION,
    SYNC_ERP_DONE,
    CANCELED,
    AWAITING_ATTENDANCE,
    ATTENDED,
    PROCESSING,
    BILLED,
    PARTIAL_BILLED,
    EMPTY_STATUS
}
