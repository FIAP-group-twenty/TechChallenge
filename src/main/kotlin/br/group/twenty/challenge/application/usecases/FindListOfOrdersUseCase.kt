package br.group.twenty.challenge.application.usecases

import br.group.twenty.challenge.domain.models.order.Order

interface FindListOfOrdersUseCase {
    fun findListOfOrders(): List<Order>?
}