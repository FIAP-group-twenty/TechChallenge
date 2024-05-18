package br.group.twenty.challenge.domain.services.order

import br.group.twenty.challenge.application.port.input.order.CreateOrderInputPort
import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order

class CreateOrderService(private val repository: CreateOrderOutputPort) : CreateOrderInputPort {

    override fun createOrder(createOrderModel: CreateOrderModel): Order {
        repository.createOrder(createOrderModel).apply {
            return Order(
                idOrder = idOrder,
                orderValue = orderValue,
                idCustomer = idCustomer,
                creationOrder = creationOrder,
                lastUpdateOrder = lastUpdateOrder,
                status = status
            )
        }
    }
}