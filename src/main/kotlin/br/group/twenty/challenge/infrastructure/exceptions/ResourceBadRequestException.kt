package br.group.twenty.challenge.infrastructure.exceptions

import br.group.twenty.challenge.infrastructure.api.entities.ErrorResponse

class ResourceBadRequestException(message: String, exception: Exception? = null) :
    RuntimeException(message, exception) {

    fun formatter(): ErrorResponse = ErrorResponse(message = message, detail = cause?.message)

}