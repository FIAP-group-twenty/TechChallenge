package br.group.twenty.challenge.api.configs;

import br.group.twenty.challenge.core.exceptions.ResourceBusinessException
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.infrastructure.api.entities.ErrorResponse
import br.group.twenty.challenge.infrastructure.exceptions.ResourceBadRequestException
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ex.formatter(), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ResourceBusinessException::class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleResourceBusinessException(ex: ResourceBusinessException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ex.formatter(), HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(ResourceBadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleResourceBadRequestException(ex: ResourceBadRequestException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ex.formatter(), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(ResourceInternalServerException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleResourceInternalServerException(ex: ResourceInternalServerException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ex.formatter(), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}

