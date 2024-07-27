package br.group.twenty.challenge.core.entities.product

data class OrderProduct(
    val id: Int,
    val quantity: Int,
    var price: Double = Double.NaN
)