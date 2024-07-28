package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

interface IOrderGateway {
    fun createOrder(order: OrderEntity): OrderEntity
    fun updateOrder(order: OrderEntity): OrderEntity
    fun updateOrderStatus(oldOrder: OrderEntity, order: UpdateOrder): OrderEntity
    fun findListOfOrders(): List<OrderEntity>
    fun findOrder(orderId: Int): OrderEntity?
}