package br.group.twenty.challenge.application.adapters.customer

import br.group.twenty.challenge.application.port.input.customer.CreateCustomerInputPort
import br.group.twenty.challenge.domain.models.customer.Customer

class CreateCustomerAdapter(private val service: CreateCustomerInputPort) : CreateCustomer {

    override fun createCustomer(createCustomerModel: br.group.twenty.challenge.domain.models.customer.CreateCustomer): Customer {
        return service.createCustomer(createCustomerModel)
    }
}