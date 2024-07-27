package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

interface IOrderGateway {
    fun createOrder(order: OrderEntity): OrderEntity
    fun updateOrder(order: OrderEntity): OrderEntity
    fun findListOfOrders(): List<OrderEntity>
    fun findOrder(orderId: Int): OrderEntity?
}