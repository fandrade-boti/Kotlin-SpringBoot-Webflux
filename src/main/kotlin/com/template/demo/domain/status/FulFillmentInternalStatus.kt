package com.template.demo.domain.status

enum class FulFillmentInternalStatus {
    CREATED,
    PENDING,
    FULFILLED,
    CANCELED,
    SPLITTED_XLS,
    UPLOADED_XLS,
    ERROR_SENDING_INTEGRATION_ERP,
    INTEGRATED_ERP,

    /**
     * Faturado
     */
    BILLED,

    /**
     * Faturado Parcial
     */
    PARTIAL_BILLED,
    RESERVE_REMOVED
}
