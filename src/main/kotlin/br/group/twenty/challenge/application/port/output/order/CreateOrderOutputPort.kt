package br.group.twenty.challenge.application.port.output.order

import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.infra.models.OrderEntity

interface CreateOrderOutputPort {
    fun createOrder(createOrderModel: CreateOrderModel): OrderEntity
}