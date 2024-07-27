package br.group.twenty.challenge.core.entities.customer

data class CreateCustomer(
    val name: String,
    val email: String,
    val cpf: String
)
