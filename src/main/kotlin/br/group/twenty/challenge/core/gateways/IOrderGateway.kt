package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

interface IOrderGateway {
    fun createOrder(createOrder: CreateOrder): Order
    fun updateOrderStatus(oldOrder: Order, order: UpdateOrder): Order
    fun findListOfOrders(): List<Order>
    fun findOrder(orderId: Int): Order?
}