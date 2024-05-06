package br.group.twenty.challenge.api

import br.group.twenty.challenge.api.dto.CreateCustomerDTO
import br.group.twenty.challenge.api.dto.CustomerDTO
import br.group.twenty.challenge.api.form.CreateCustomerForm
import br.group.twenty.challenge.domain.service.CustomerService
import br.group.twenty.challenge.domain.service.GetCustomerByCpf
import jakarta.validation.constraints.Null
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/customers")
@RestController
class CustomerController(
    private val service: CustomerService,
    private val getCustomerByCpf: GetCustomerByCpf
) {

    @PostMapping
    fun create(@RequestBody createCustomerForm: CreateCustomerForm): ResponseEntity<CreateCustomerDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(createCustomerForm))
    }

    @GetMapping("/{cpf}")
    fun getCustomerByCpf(@PathVariable cpf: String): ResponseEntity<Any> {
        val customer = getCustomerByCpf.execute(cpf)
        return if (customer != null) {
            ResponseEntity.ok(customer)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found for CPF: $cpf")
        }
    }
}