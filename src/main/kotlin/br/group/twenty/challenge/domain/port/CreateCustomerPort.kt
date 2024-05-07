package br.group.twenty.challenge.domain.port

import br.group.twenty.challenge.infra.data.model.CreateCustomer
import br.group.twenty.challenge.domain.model.Customer

interface CreateCustomerPort {
    fun createCustomer(createCustomer: CreateCustomer): Customer
}