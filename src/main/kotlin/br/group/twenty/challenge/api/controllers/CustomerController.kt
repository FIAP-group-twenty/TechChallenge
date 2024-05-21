package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.adapters.customer.FindCustomer
import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.domain.models.customer.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val createCustomer: br.group.twenty.challenge.application.adapters.customer.CreateCustomer,
    private val findCustomer: FindCustomer
) {

    @PostMapping
    fun create(@RequestBody createCustomer: CreateCustomer): ResponseEntity<Customer> {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.createCustomer.createCustomer(createCustomer))
    }

    @GetMapping("/{cpf}")
    fun getCustomerByCpf(@PathVariable cpf: String): ResponseEntity<Any> {
        return ResponseEntity.ok(findCustomer.findCustomerByCpf(cpf))
    }
}