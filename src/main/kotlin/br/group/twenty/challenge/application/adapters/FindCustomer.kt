package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.domain.models.Customer

interface FindCustomer {
    fun findCustomerByCpf(cpf: String): Customer?
}