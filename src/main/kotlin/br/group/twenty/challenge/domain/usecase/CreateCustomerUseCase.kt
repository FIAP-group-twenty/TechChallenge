package br.group.twenty.challenge.domain.usecase

import br.group.twenty.challenge.infra.data.model.CreateCustomer
import br.group.twenty.challenge.domain.model.Customer

interface CreateCustomerUseCase {
    fun createCustomer(createCustomer: CreateCustomer): Customer
}