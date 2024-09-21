package br.group.twenty.challenge.infrastructure.api.entities

import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import com.mercadopago.resources.payment.Payment

data class PaymentInformation(
    val payment: Payment,
    val order: Order
)
