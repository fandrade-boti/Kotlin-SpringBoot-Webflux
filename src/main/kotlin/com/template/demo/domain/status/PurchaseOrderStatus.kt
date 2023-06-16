package com.template.demo.domain.status

enum class PurchaseOrderStatus {
    OPEN,

    /**
     * Concluído
     */
    CLOSED,
    PENDING,

    /**
     * Cancelado
     */
    CANCELED,

    /**
     * Recusado
     */
    REFUSED,

    /**
     * Aguardando atendimento
     */
    AWAITING_ATTENDANCE,

    /**
     * Em Atendimento
     */
    IN_ATTENDANCE,

    /**
     * Faturado
     */
    BILLED,

    EMPTY_STATUS
}
