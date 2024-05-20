package br.group.twenty.challenge.application.adapters.order

import br.group.twenty.challenge.application.port.input.order.CreateOrderInputPort
import br.group.twenty.challenge.application.port.input.order.FindListOfOrdersInputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.domain.models.order.Order

class FindListOfOrdersAdapter(
    private val service: FindListOfOrdersInputPort
): FindListOfOrders {

    override fun findListOfOrders(): List<Order> {
        return service.findListOfOrders()
    }
}