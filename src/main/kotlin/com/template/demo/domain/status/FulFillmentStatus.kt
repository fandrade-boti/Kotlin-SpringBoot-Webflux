package com.template.demo.domain.status

enum class FulFillmentStatus {
    /**
     * Aberto
     */
    OPEN,

    /**
     * Concluído
     */
    CLOSED,

    /**
     * Pendente
     */
    PENDING,

    /**
     * Cancelado
     */
    CANCELED,

    /**
     * Pendente Atendimento
     */
    PENDING_ATTENDANCE,

    /**
     * Em Processamento
     */
    PROCESSING,

    /**
     * Processado
     */
    PROCESSED,

    /**
     * Recusado
     */
    REFUSED,

    /**
     * Pendente Integração com ERP
     */
    PENDING_ITG_ERP,

    /**
     * Em Integração ERP
     */
    IN_ERP_INTEGRATION,

    /**
     * Pendente de Faturamento
     */
    PENDING_BILLING,

    /**
     * Erro de Integração ERP
     */
    ERP_INTEGRATION_ERROR,

    /**
     * Faturado
     */
    BILLED,

    /**
     * Faturado Parcial
     */
    PARTIAL_BILLED,

    PENDING_DELIVERY
}
