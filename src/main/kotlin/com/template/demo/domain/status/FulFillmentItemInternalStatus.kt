package com.template.demo.domain.status

enum class FulFillmentItemInternalStatus {
    CREATED,
    INTEGRATED_FAILED,
    INTEGRATED_ERP,
    PENDING,
    ON_HOLD,
    REJECTED,
    SCHEDULED,
    PARTIALLY_FULFILLED,
    FULFILLED,
    ERROR_VALIDATION,
    SYNC_ERP_DONE,
    CANCELED,

    /**
     * Faturado
     */
    BILLED,

    /**
     * Faturado Parcial
     */
    PARTIAL_BILLED,
    RESERVED,
    RESERVE_ERROR,
    RESERVE_REMOVED,
    RESERVE_REMOVED_ERROR,
    BILLED_AWAITING_NFE,
    PARTIAL_BILLED_AWAITING_NFE
}
