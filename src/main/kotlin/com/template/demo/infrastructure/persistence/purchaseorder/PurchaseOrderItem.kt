package com.template.demo.infrastructure.persistence.purchaseorder

import com.template.demo.domain.status.PurchaseOrderItemInternalStatus
import com.template.demo.domain.status.PurchaseOrderItemStatus
import com.template.demo.domain.type.SkuBrandType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "purchaseOrderItem")
@EntityListeners(AuditingEntityListener::class)
data class PurchaseOrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,

    val purchaseOrderId: Long,

    @Column(length = 50)
    val skuCode: String,

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    val skuBrand: SkuBrandType,

    @Column(length = 200)
    @Enumerated(EnumType.STRING)
    val status: PurchaseOrderItemStatus,

    @Column(length = 200)
    @Enumerated(EnumType.STRING)
    val statusInternal: PurchaseOrderItemInternalStatus,

    val originalQuantity: Int, // 50
    val requestQuantity: Int,
    val pendingQuantity: Int?, // null, 20 -> 0
    val deliveredQuantity: Int?, // null, 30 -> 20
    val refusedQuantity: Int?,
    val suggestedEmitterQuantity: Int?,

    @Column(length = 50)
    val errorCode: String?,
    val errorMessage: String?,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now(),
)
