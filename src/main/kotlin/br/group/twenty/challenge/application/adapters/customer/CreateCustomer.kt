package br.group.twenty.challenge.application.adapters.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.domain.models.customer.Customer

interface CreateCustomer {
    fun createCustomer(createCustomerModel: CreateCustomer): Customer
}