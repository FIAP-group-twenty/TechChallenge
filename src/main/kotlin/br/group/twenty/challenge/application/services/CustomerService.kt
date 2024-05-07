package br.group.twenty.challenge.application.services

import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.domain.ports.CreateCustomerPort
import br.group.twenty.challenge.domain.models.Customer

class CustomerService(private val repository: CreateCustomerPort) : CreateCustomerPort {
    override fun createCustomer(createCustomer: CreateCustomer): Customer {
        return  repository.createCustomer(createCustomer)
    }
}