package br.group.twenty.challenge.core.entities.order

import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import java.time.LocalDateTime

data class UpdateOrder(
    val status: String,
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now(),
    val payment: PaymentEntity? = null
)