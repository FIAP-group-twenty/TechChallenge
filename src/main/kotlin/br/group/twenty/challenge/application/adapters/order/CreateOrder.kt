package br.group.twenty.challenge.application.adapters.order

import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order

interface CreateOrder {
    fun createOrder(createOrderModel: CreateOrderModel): Order
}