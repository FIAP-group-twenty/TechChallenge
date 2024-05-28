package br.group.twenty.challenge.domain.models.product

data class Product(
    val id: Int? = null,
    val name: String,
    val category: String,
    val price: Double,
    val description: String
)