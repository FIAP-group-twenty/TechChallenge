package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.adapters.customer.CreateCustomer
import br.group.twenty.challenge.application.adapters.customer.FindCustomer
import br.group.twenty.challenge.domain.models.customer.CreateCustomerModel
import br.group.twenty.challenge.domain.models.customer.Customer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val createCustomer: CreateCustomer,
    private val findCustomer: FindCustomer

) {

    @PostMapping
    fun create(@RequestBody createCustomerModel: CreateCustomerModel): ResponseEntity<Customer> {
        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomer.createCustomer(createCustomerModel))
    }

    @GetMapping("/{cpf}")
    fun getCustomerByCpf(@PathVariable cpf: String): ResponseEntity<Any> {
        val customer = findCustomer.findCustomerByCpf(cpf)
        return if (customer != null) {
            ResponseEntity.ok(customer)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found for CPF: $cpf")
        }
    }
}