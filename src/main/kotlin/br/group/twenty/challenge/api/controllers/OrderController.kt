package br.group.twenty.challenge.api.controllers;

import br.group.twenty.challenge.application.adapters.order.CreateOrder
import br.group.twenty.challenge.application.adapters.order.FindListOfOrders
import br.group.twenty.challenge.application.usecases.FindListOfOrdersUseCase
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/order")
@RestController
class OrderController(
    private val createOrder: CreateOrder,
    private val findListOfOrders: FindListOfOrders
) {

    @PostMapping
    fun create(@RequestBody createOrderModel: CreateOrderModel): ResponseEntity<Order> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createOrder.createOrder(createOrderModel))
    }

    @GetMapping
    fun getListOfOrders(): ResponseEntity<List<Order>> {
        val orders = findListOfOrders.findListOfOrders()
        return ResponseEntity.ok(orders)
    }
}
