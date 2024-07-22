package br.group.twenty.challenge.domain.models.payment

import br.group.twenty.challenge.infra.models.OrderEntity
import java.math.BigDecimal
import java.time.LocalDateTime

class Payment(
    val idPay: Int? = null,
    val order: OrderEntity? = null,
    val qrCode: String? = null,
    val status: String,
    val payValue: BigDecimal,
    val creationOrder: LocalDateTime? = LocalDateTime.now(),
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now()
)