package br.group.twenty.challenge.application.port.output.order

import br.group.twenty.challenge.infra.models.OrderEntity

interface FindListOfOrdersOutputPort {
    fun findListOfOrders(): List<OrderEntity>
}