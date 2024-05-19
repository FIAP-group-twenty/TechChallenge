package br.group.twenty.challenge.domain.models.order

import java.math.BigDecimal

data class CreateOrderModel(
    val orderValue: BigDecimal,
    val idCustomer: Int? = null,
    val status: String
)