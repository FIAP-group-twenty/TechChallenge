package br.group.twenty.challenge.domain.models.product

data class Product(
    val id: Int? = null,
    val name: String? = null,
    val category: String? = null,
    val price: Double? = null,
    val description: String? = null
)