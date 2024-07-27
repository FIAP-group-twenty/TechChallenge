package br.group.twenty.challenge.infrastructure.api.entities

data class ErrorResponse(
    val message: String?,
    val detail: String? = null
)