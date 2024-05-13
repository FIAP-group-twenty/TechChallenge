package br.group.twenty.challenge.application.port.output

import br.group.twenty.challenge.infra.models.CustomerEntity

interface FindCustomerOutputPort {
    fun findCustomerByCpf(cpf: String): CustomerEntity?
}