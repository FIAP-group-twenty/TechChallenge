package br.group.twenty.challenge.application.port.input

import br.group.twenty.challenge.domain.models.CreateCustomerModel
import br.group.twenty.challenge.domain.models.Customer

interface CreateCustomerInputPort {
    fun createCustomer(createCustomerModel: CreateCustomerModel): Customer
}