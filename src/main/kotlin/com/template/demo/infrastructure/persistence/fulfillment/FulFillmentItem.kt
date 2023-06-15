package com.template.demo.infrastructure.persistence.fulfillment

import com.template.demo.domain.status.FulFillmentItemInternalStatus
import com.template.demo.domain.status.FulFillmentItemStatus
import com.template.demo.domain.type.RefusalReasonType
import com.template.demo.domain.type.SkuBrandType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "fulfillment_item")
@EntityListeners(AuditingEntityListener::class)
data class FulFillmentItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,
    val guid: String,

    val fulfillmentId: Long,
    val purchaseOrderItemId: Long,
    val originFulfillmentItemId: Long?,
    val destinyFulfillmentItemId: Long?,

    @Enumerated(EnumType.STRING)
    val status: FulFillmentItemStatus,

    @Enumerated(EnumType.STRING)
    val statusInternal: FulFillmentItemInternalStatus,

    val skuCode: String,
    val skuGroup: String?,


    val xls: Boolean = false,

    val originalQuantity: Int,
    val requestQuantity: Int,
    val pendingQuantity: Int?,
    val deliveredQuantity: Int?,
    val refusedQuantity: Int?,


    val expectedBackofficeDate: LocalDateTime?,
    val backofficeDate: LocalDateTime?,
    val expectedDeliveryDate: LocalDateTime?,
    val deliveredDate: LocalDateTime?,


    val refusalCode: String?,
    val refusalReason: String?,

    @Enumerated(EnumType.STRING)
    val refusalType: RefusalReasonType?,


    val errorCode: String?,
    val errorMessage: String?,





    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
