package br.group.twenty.challenge.core.entities.payment

import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import java.math.BigDecimal
import java.time.LocalDateTime

class Payment(
    val idPay: Int? = null,
    val mercadoPagoId: Int? = null,
    val order: Order? = null,
    val qrCode: String? = null,
    val status: String,
    val payValue: BigDecimal,
    val creationOrder: LocalDateTime? = LocalDateTime.now(),
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now()
)
