package br.group.twenty.challenge.core.entities.product

import java.math.BigDecimal

data class Product(
    val id: Int? = null,
    val name: String? = null,
    val category: String? = null,
    val price: BigDecimal = BigDecimal.ZERO,
    val description: String? = null
)