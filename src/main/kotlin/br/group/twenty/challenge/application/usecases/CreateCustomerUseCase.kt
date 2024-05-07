package br.group.twenty.challenge.application.usecases

import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.domain.models.Customer

interface CreateCustomerUseCase {
    fun createCustomer(createCustomer: CreateCustomer): Customer
}