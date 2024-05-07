package br.group.twenty.challenge.domain.models

data class CreateCustomer(
    val name: String,
    val email: String,
    val cpf: String
)
