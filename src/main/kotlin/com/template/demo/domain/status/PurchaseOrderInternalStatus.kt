package com.template.demo.domain.status

enum class PurchaseOrderInternalStatus {
    CREATED,
    PENDING,
    PARTIALLY_FULFILLED,
    FULFILLED,
    ERROR_CREATION,
    SYNC_ERP_DONE,
    CANCELED,
    ERP_NOT_FOUND,
    ERP_TO_BE_DEFINE,
    IN_ATTENDANCE,

    /**
     * Aguardando Enriquecimento
     */
    AWAITING_ENRICHMENT,

    /**
     * Em Enriquecimento
     */
    IN_ENRICHMENT,

    /**
     * Aguardando Atendimento
     */
    AWAITING_ATTENDANCE,

    /**
     * Concluído
     */
    CLOSED,

    /**
     * Atendimento em análise
     */
    SERVICE_UNDER_ANALYSIS,

    /**
     * Atendimento agendado
     */
    SCHEDULED_SERVICE,

    /**
     * Atendimento finalizado
     */
    SERVICE_FINISHED,

    /**
     * Em Integração ERP
     */
    IN_ERP_INTEGRATION,

    /**
     * Integrado ERP
     */
    INTEGRATED_ERP,

    /**
     * Erro Envio Integração ERP
     */
    ERROR_SENDING_INTEGRATION_ERP,

    /**
     * Erro de Integração ERP
     */
    ERP_INTEGRATION_ERROR,

    /**
     * ERP com vigência antecipada
     */
    ERP_VALIDITY_ANTICIPATED,
    /**
     * Erro na geração de Ordem de venda
     */
    SALES_ORDER_GENERATION_ERROR,

    /**
     * Aguardando faturamento
      */
    AWAITING_BILLING,

    /**
     * Faturado
     */
    BILLED,

}
