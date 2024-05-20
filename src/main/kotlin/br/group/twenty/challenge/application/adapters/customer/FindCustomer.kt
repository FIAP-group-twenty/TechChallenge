package br.group.twenty.challenge.application.adapters.customer

import br.group.twenty.challenge.domain.models.customer.Customer

interface FindCustomer {
    fun findCustomerByCpf(cpf: String): Customer
}