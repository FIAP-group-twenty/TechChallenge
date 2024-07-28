package br.group.twenty.challenge.core.entities.customer

data class Customer(
    val id: Int? = null,
    val name: String,
    val email: String,
    val cpf: String
)