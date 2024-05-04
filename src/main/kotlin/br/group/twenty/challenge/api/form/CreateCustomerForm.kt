package br.group.twenty.challenge.api.form

data class CreateCustomerForm(
    val name: String,
    val email: String,
    val cpf: String
)
