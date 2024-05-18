package br.group.twenty.challenge.application.port.input.order

import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order

interface CreateOrderInputPort {
    fun createOrder(createOrderModel: CreateOrderModel): Order
}