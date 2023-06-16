package com.template.demo.infrastructure.persistence.purchaseorder

import com.template.demo.domain.sap.ErpType
import com.template.demo.domain.status.PurchaseOrderInternalStatus
import com.template.demo.domain.status.PurchaseOrderStatus
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.annotation.Id
import javax.persistence.*
import javax.persistence.Column
@Entity
@Table(name = "purchase_order")
@EntityListeners(AuditingEntityListener::class)
data class PurchaseOrder(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long,

    @Column(length = 30)
    val storeCode: String,

    @Column(length = 200)
    @Enumerated(EnumType.STRING)
    val status: PurchaseOrderStatus
    ,
    @Column(length = 200)
    @Enumerated(EnumType.STRING)
    val statusInternal: PurchaseOrderInternalStatus,

    @Column(length = 30)
    val businessUnit: String,

    @Column(length = 100)
    val shippingType: String?,

    @Enumerated(EnumType.STRING)
    val erp: ErpType?,

    @Column(length = 50)
    val errorCode: String?,

    val errorMessage: String?,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now(),
)
