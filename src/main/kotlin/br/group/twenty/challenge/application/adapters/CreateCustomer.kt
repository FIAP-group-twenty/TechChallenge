package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.domain.models.CreateCustomerModel
import br.group.twenty.challenge.domain.models.Customer

interface CreateCustomer {
    fun createCustomer(createCustomerModel: CreateCustomerModel): Customer
}