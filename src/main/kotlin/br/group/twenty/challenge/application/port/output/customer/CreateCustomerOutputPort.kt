package br.group.twenty.challenge.application.port.output.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomerModel
import br.group.twenty.challenge.infra.models.CustomerEntity

interface CreateCustomerOutputPort {
    fun createCustomer(createCustomerModel: CreateCustomerModel): CustomerEntity
}