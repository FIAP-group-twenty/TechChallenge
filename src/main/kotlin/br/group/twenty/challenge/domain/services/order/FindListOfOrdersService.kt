package br.group.twenty.challenge.domain.services.order

import br.group.twenty.challenge.application.port.input.order.FindListOfOrdersInputPort
import br.group.twenty.challenge.application.port.output.order.FindListOfOrdersOutputPort
import br.group.twenty.challenge.domain.models.order.Order

class FindListOfOrdersService(private val repository: FindListOfOrdersOutputPort) : FindListOfOrdersInputPort {

    override fun findListOfOrders(): List<Order> {
        val orderEntities = repository.findListOfOrders()
        return orderEntities.map { entity ->
            Order(
                idOrder = entity.idOrder,
                orderValue = entity.orderValue,
                idCustomer = entity.idCustomer,
                creationOrder = entity.creationOrder,
                lastUpdateOrder = entity.lastUpdateOrder,
                status = entity.status,
                orderItems = entity.orderItens
            )
        }
    }
}