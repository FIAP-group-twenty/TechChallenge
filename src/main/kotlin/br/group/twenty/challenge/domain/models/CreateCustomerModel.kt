package br.group.twenty.challenge.domain.models

data class CreateCustomerModel(
    val name: String,
    val email: String,
    val cpf: String
)
