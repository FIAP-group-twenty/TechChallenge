package br.group.twenty.challenge.domain.service

import br.group.twenty.challenge.api.dto.CreateCustomerDTO
import br.group.twenty.challenge.api.form.CreateCustomerForm
import br.group.twenty.challenge.domain.model.Customer
import br.group.twenty.challenge.domain.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val repository: CustomerRepository) {

    fun createCustomer(customerForm: CreateCustomerForm): CreateCustomerDTO {
        if (repository.findByCpf(customerForm.cpf) != null) throw Exception("customer already exists")
        repository.save(Customer(name = customerForm.name, cpf = customerForm.cpf, email = customerForm.email))
        return CreateCustomerDTO(name = customerForm.name, email = customerForm.email)
    }
}