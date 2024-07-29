package br.group.twenty.challenge.core.entities.payment

data class Notification(
    val type: String,
    val data: Data
)

data class Data(
    val id: String
)