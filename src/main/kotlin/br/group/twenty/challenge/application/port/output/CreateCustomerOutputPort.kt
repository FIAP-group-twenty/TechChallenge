package br.group.twenty.challenge.application.port.output

import br.group.twenty.challenge.domain.models.CreateCustomerModel
import br.group.twenty.challenge.infra.models.CustomerEntity

interface CreateCustomerOutputPort {
    fun createCustomer(createCustomerModel: CreateCustomerModel): CustomerEntity
}