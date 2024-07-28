package br.group.twenty.challenge.infrastructure.exceptions

import br.group.twenty.challenge.infrastructure.api.entities.ErrorResponse

class ResourceInternalServerException(message: String = "An unexpected error occurred", exception: Exception? = null) :
    RuntimeException(message, exception) {

    fun formatter(): ErrorResponse = ErrorResponse(message = message, detail = cause?.cause?.message)

}