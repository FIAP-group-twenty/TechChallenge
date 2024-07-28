package br.group.twenty.challenge.core.exceptions

import br.group.twenty.challenge.infrastructure.api.entities.ErrorResponse

class ResourceBusinessException(message: String) : RuntimeException(message) {

    fun formatter(): ErrorResponse = ErrorResponse(message = message)

}