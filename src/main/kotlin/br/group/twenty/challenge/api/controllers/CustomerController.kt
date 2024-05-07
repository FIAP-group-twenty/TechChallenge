package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.usecases.CreateCustomerUseCase
import br.group.twenty.challenge.application.usecases.FindCustomerUseCase
import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.domain.models.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val createCustomerUseCase: CreateCustomerUseCase,
    private val findCustomerUseCase: FindCustomerUseCase
) {

    @PostMapping
    fun create(@RequestBody createCustomer: CreateCustomer): ResponseEntity<Customer> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerUseCase.createCustomer(createCustomer))
    }

    @GetMapping("/{cpf}")
    fun getCustomerByCpf(@PathVariable cpf: String): ResponseEntity<Any> {
        val customer = findCustomerUseCase.findCustomerByCpf(cpf)
        return if (customer != null) {
            ResponseEntity.ok(customer)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found for CPF: $cpf")
        }
    }
}