package br.group.twenty.challenge.api

import br.group.twenty.challenge.api.dto.CreateCustomerDTO
import br.group.twenty.challenge.api.form.CreateCustomerForm
import br.group.twenty.challenge.domain.model.Customer
import br.group.twenty.challenge.domain.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val service: CustomerService
) {

    @PostMapping
    fun create(@RequestBody createCustomerForm: CreateCustomerForm): ResponseEntity<CreateCustomerDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(createCustomerForm))
    }

}