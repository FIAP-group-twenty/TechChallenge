package br.group.twenty.challenge.core.usecases.order

import br.group.twenty.challenge.core.entities.order.CreateOrderModel
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

class CreateOrderUseCase(
    private val gateway: IOrderGateway
) {
    fun execute(createOrderModel: CreateOrderModel): OrderEntity {
        return gateway.createOrder(createOrderModel)
    }
}