package br.group.twenty.challenge.application.port.input.order

import br.group.twenty.challenge.domain.models.order.Order

interface FindListOfOrdersInputPort {
    fun findListOfOrders(): List<Order>
}