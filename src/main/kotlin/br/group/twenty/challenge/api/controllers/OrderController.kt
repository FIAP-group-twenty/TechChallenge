package br.group.twenty.challenge.api.controllers;

import br.group.twenty.challenge.application.adapters.order.CreateOrder
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/order")
@RestController
class OrderController(
    private val createOrder: CreateOrder
) {

    @PostMapping
    fun create(@RequestBody createOrderModel: CreateOrderModel): ResponseEntity<Order> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrder.createOrder(createOrderModel))
    }
}
