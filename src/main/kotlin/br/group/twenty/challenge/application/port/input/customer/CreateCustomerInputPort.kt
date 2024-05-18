package br.group.twenty.challenge.application.port.input.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomerModel
import br.group.twenty.challenge.domain.models.customer.Customer

interface CreateCustomerInputPort {
    fun createCustomer(createCustomerModel: CreateCustomerModel): Customer
}