package br.group.twenty.challenge.domain.models.order

import java.math.BigDecimal
import java.time.LocalDateTime

data class CreateOrderModel(
    val orderValue: BigDecimal,
    val idCustomer: Int? = null,
    val status: String
)