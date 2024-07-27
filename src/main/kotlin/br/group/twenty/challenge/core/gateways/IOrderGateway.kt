package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.order.CreateOrderModel
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

interface IOrderGateway {
    fun createOrder(createOrderModel: CreateOrderModel): OrderEntity
    fun findListOfOrders(): List<OrderEntity>
}