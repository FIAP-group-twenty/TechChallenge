package br.group.twenty.challenge.application.usecases.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.domain.models.customer.Customer

interface CreateCustomerUseCase {
    fun createCustomer(createCustomer: CreateCustomer): Customer
}