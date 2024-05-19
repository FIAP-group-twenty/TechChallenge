package br.group.twenty.challenge.domain.ports

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.infra.models.CustomerEntity

interface CustomerPort {
    fun createCustomer(createCustomer: CreateCustomer): CustomerEntity
    fun findCustomerByCpf(cpf: String): CustomerEntity?
}