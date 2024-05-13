package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.application.port.input.CreateCustomerInputPort
import br.group.twenty.challenge.domain.models.CreateCustomerModel
import br.group.twenty.challenge.domain.models.Customer

class CreateCustomerAdapter(private val service: CreateCustomerInputPort) : CreateCustomer {

    override fun createCustomer(createCustomerModel: CreateCustomerModel): Customer {
        return service.createCustomer(createCustomerModel)
    }
}