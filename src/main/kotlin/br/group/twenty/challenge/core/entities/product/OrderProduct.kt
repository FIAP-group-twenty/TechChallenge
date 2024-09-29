package br.group.twenty.challenge.core.entities.product

import java.math.BigDecimal

data class OrderProduct(
    val id: Int,
    val quantity: Int,
    var price: BigDecimal = BigDecimal.ZERO
)