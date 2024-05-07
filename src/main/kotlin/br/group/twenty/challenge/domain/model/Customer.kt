package br.group.twenty.challenge.domain.model

data class Customer(
    val id: Int? = null,
    val name: String,
    val email: String,
    val cpf: String
)