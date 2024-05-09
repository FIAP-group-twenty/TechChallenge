package br.group.twenty.challenge.application.port.input

import br.group.twenty.challenge.domain.models.Customer

interface FindCustomerInputPort {
    fun findCustomerByCpf(cpf: String): Customer?
}