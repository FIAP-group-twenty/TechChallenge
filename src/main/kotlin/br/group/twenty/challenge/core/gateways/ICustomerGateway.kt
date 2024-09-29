package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

interface ICustomerGateway {
    fun createCustomer(createCustomerModel: CreateCustomer): Customer
    fun findCustomerByCpf(cpf: String): Customer?
}