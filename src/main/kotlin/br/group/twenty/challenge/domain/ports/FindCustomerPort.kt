package br.group.twenty.challenge.domain.ports

import br.group.twenty.challenge.domain.models.Customer

interface FindCustomerPort {
    fun findCustomerByCpf(cpf: String): Customer?
}