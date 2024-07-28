package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.api.presenters.CustomerPresenter
import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.core.usecases.customer.CreateCustomerUseCase
import br.group.twenty.challenge.core.usecases.customer.GetCustomerUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val createCustomerUseCase: CreateCustomerUseCase,
    private val getCustomerUseCase: GetCustomerUseCase
) {

    @PostMapping
    fun create(@RequestBody createCustomer: CreateCustomer): ResponseEntity<Customer> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CustomerPresenter.formatter(createCustomerUseCase.execute(createCustomer), createCustomer.cpf))
    }

    @GetMapping("/{cpf}")
    fun getCustomerByCpf(@PathVariable cpf: String): ResponseEntity<Any> {
        return ResponseEntity.ok(CustomerPresenter.formatter(getCustomerUseCase.execute(cpf), cpf))
    }
}