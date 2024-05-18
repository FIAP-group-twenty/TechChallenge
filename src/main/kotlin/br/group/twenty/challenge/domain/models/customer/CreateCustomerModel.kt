package br.group.twenty.challenge.domain.models.customer

data class CreateCustomerModel(
    val name: String,
    val email: String,
    val cpf: String
)
