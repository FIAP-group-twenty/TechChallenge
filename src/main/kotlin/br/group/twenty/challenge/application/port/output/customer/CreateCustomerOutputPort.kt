package br.group.twenty.challenge.application.port.output.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.infra.models.CustomerEntity

interface CreateCustomerOutputPort {
    fun createCustomer(createCustomerModel: CreateCustomer): CustomerEntity
}