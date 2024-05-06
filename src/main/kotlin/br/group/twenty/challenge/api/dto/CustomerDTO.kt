package br.group.twenty.challenge.api.dto

data class CustomerDTO(
    val id: Int?,
    val name: String,
    val email: String,
    val cpf: String
)