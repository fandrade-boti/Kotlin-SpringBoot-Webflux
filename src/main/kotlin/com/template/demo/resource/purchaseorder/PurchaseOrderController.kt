package com.template.demo.resource.purchaseorder

import com.template.demo.domain.model.PurchaseOrderService
import com.template.demo.infrastructure.persistence.purchaseorder.PurchaseOrder
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/purchase-orders")
class PurchaseOrderController(
    private val purchaseOrderService: PurchaseOrderService
) {


    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Long): ResponseEntity<Any> {

        return ResponseEntity.ok("Success")

    }

    @PostMapping
    fun saveOrder(@RequestBody purchaseOrder: PurchaseOrder): ResponseEntity<Any> {

        purchaseOrderService.save(purchaseOrder)
        return ResponseEntity.ok("Success")

    }
}