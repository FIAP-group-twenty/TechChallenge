package br.group.twenty.challenge.api.presenters

import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

object OrderPresenter {

    fun formatterOrder(order: OrderEntity): Order {
        return Order(
            idOrder = order.idOrder,
            orderValue = order.orderValue,
            idCustomer = order.idCustomer,
            creationOrder = order.creationOrder,
            lastUpdateOrder = order.lastUpdateOrder,
            status = order.status,
            orderItems = order.orderItens,
            payment = order.payment
        )
    }

    fun formatterOrderList(orders: List<OrderEntity>): List<Order> {
        return orders.map { order ->
            formatterOrder(order)
        }
    }
}