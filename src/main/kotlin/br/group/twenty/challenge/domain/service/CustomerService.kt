package br.group.twenty.challenge.domain.service

import br.group.twenty.challenge.infra.data.model.CreateCustomer
import br.group.twenty.challenge.domain.port.CreateCustomerPort
import br.group.twenty.challenge.domain.model.Customer

class CustomerService(private val repository: CreateCustomerPort) : CreateCustomerPort {
    override fun createCustomer(createCustomer: CreateCustomer): Customer {
        return  repository.createCustomer(createCustomer)
    }
}