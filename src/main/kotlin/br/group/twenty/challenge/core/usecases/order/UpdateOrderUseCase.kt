package br.group.twenty.challenge.core.usecases.order

import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.infrastructure.gateways.order.OrderGateway

class UpdateOrderUseCase(
    private val gateway: OrderGateway
) {
    fun execute(id: Int, updateOrder: UpdateOrder): Order {
        gateway.findOrder(id).let { oldOrder ->
            return gateway.updateOrderStatus(oldOrder, updateOrder)
        }
    }
}