package com.template.demo.domain.status

enum class FulFillmentItemStatus {
    OPEN,
    CREATED,
    INTEGRATED_FAILED,
    INTEGRATED_ERP,
    ERP_INTEGRATION_ERROR,
    PENDING,
    PROCESSING,
    PROCESSED,
    ON_HOLD,
    REJECTED,
    SCHEDULED,
    RESCHEDULED,
    PARTIALLY_FULFILLED,
    FULFILLED,
    ERROR_VALIDATION,
    SYNC_ERP_DONE,
    CANCELED,
    REPLACED,
    POSTPONED,

    /**
     * Faturado
     */
    BILLED,

    /**
     * Faturado Parcial
     */
    PARTIAL_BILLED,

    /**
     * Recusado
     */
    REFUSED,

    NOT_BILLED
}
