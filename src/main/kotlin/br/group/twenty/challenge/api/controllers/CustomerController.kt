package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.usecases.CreateCustomerUseCase
import br.group.twenty.challenge.application.usecases.FindCustomerUseCase
import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.domain.models.Customer
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val createCustomerUseCase: CreateCustomerUseCase,
    private val findCustomerUseCase: FindCustomerUseCase
) {

    @PostMapping
    fun create(@RequestBody createCustomer: CreateCustomer): ResponseEntity<Customer> {
        return ResponseEntity.status(CREATED).body(createCustomerUseCase.createCustomer(createCustomer))
    }

    @GetMapping("/{cpf}")
    fun getCustomerByCpf(@PathVariable cpf: String): ResponseEntity<Any> {
        val customer = findCustomerUseCase.findCustomerByCpf(cpf)
        return if (customer != null) {
            ResponseEntity.ok(customer)
        } else {
            ResponseEntity.status(NOT_FOUND).body("Customer not found for CPF: $cpf")
        }
    }
}