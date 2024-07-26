package br.group.twenty.challenge.core.exceptions;

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ResourceBusinessException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceBusinessException(ex: ResourceBusinessException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}

