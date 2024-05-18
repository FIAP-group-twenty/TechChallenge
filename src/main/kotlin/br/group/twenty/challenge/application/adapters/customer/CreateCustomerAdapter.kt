package br.group.twenty.challenge.application.adapters.customer

import br.group.twenty.challenge.application.port.input.customer.CreateCustomerInputPort
import br.group.twenty.challenge.domain.models.customer.CreateCustomerModel
import br.group.twenty.challenge.domain.models.customer.Customer
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

class CreateCustomerAdapter(private val service: CreateCustomerInputPort) : CreateCustomer {

    override fun createCustomer(createCustomerModel: CreateCustomerModel): Customer {
        return service.createCustomer(createCustomerModel)
    }
}