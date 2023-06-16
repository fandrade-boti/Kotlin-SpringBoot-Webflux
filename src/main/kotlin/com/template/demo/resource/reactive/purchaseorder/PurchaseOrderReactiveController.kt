package com.template.demo.resource.reactive.purchaseorder

import com.template.demo.domain.model.PurchaseOrderService
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@Validated
@RestController
@RequestMapping("/reactive-purchase-orders")
class PurchaseOrderReactiveController(
    private val purchaseOrderService: PurchaseOrderService
) {
    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Long): Mono<PurchaseOrder> {
        return purchaseOrderService.findById(id)
    }

    @PostMapping
    fun insertOrder(@RequestBody purchaseOrder: PurchaseOrder): Mono<Long?>? {
        return purchaseOrderService.insert(purchaseOrder)
    }
}