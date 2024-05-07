package br.group.twenty.challenge.domain.ports

import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.domain.models.Customer

interface CreateCustomerPort {
    fun createCustomer(createCustomer: CreateCustomer): Customer
}