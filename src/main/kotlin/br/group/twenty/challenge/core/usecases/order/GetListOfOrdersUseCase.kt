package br.group.twenty.challenge.core.usecases.order

import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity

class GetListOfOrdersUseCase(
    private val gateway: IOrderGateway
) {

    fun execute(): List<OrderEntity> {
        return gateway.findListOfOrders()
    }
}