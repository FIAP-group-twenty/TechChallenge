package br.group.twenty.challenge.application.port.input.customer

import br.group.twenty.challenge.domain.models.customer.Customer

interface FindCustomerInputPort {
    fun findCustomerByCpf(cpf: String): Customer?
}