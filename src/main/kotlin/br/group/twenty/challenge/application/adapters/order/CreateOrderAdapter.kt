package br.group.twenty.challenge.application.adapters.order

import br.group.twenty.challenge.application.port.input.order.CreateOrderInputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order

class CreateOrderAdapter(
    private val service: CreateOrderInputPort
): CreateOrder {

    override fun createOrder(createOrderModel: CreateOrderModel): Order {
        return service.createOrder(createOrderModel)
    }
}