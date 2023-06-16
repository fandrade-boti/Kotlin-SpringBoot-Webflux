package com.template.demo.infrastructure.persistence.fulfillment

import com.template.demo.domain.status.FulFillmentInternalStatus
import com.template.demo.domain.status.FulFillmentStatus
import com.template.demo.domain.type.FulfillmentTagType
import com.vladmihalcea.hibernate.type.json.JsonType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "fulfillment")
@EntityListeners(AuditingEntityListener::class)
@TypeDef(name = "jsonb", typeClass = JsonType::class)
data class FulFillment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0L,
    val purchaseOrderId: Long,

    @Enumerated(EnumType.STRING)
    val status: FulFillmentStatus,

    @Enumerated(EnumType.STRING)
    val statusInternal: FulFillmentInternalStatus,

    val salesOrderIdentifier: String?,
    val pointSaleIdentifier: String?,
    val shippingType: String?,

    val errorCode: String?,
    val errorMessage: String?,

    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now(),

)
