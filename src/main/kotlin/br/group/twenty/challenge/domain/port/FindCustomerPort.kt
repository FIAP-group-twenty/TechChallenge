package br.group.twenty.challenge.domain.port

import br.group.twenty.challenge.domain.model.Customer

interface FindCustomerPort {
    fun findCustomerByCpf(cpf: String): Customer?
}