package br.group.twenty.challenge.api.controllers;

import br.group.twenty.challenge.api.presenters.OrderPresenter
import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.core.usecases.order.CreateOrderUseCase
import br.group.twenty.challenge.core.usecases.order.GetListOfOrdersUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/order")
@RestController
class OrderController(
    private val createOrderUseCase: CreateOrderUseCase,
    private val getListOfOrdersUseCase: GetListOfOrdersUseCase
) {

    @PostMapping
    fun create(@RequestBody createOrder: CreateOrder): ResponseEntity<Order> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(OrderPresenter.formatterOrder(createOrderUseCase.execute(createOrder)))
    }

    @GetMapping
    fun getListOfOrders(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(OrderPresenter.formatterOrderList(getListOfOrdersUseCase.execute()))
    }

    @PutMapping
    fun updateOrderStatus() {

    } //todo: implementar update do status do order
}
