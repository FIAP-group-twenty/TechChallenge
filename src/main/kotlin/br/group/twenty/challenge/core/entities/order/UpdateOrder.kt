package br.group.twenty.challenge.core.entities.order

import java.time.LocalDateTime

data class UpdateOrder(
    val status: String,
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now()
)