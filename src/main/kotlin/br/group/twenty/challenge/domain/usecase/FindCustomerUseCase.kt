package br.group.twenty.challenge.domain.usecase

import br.group.twenty.challenge.domain.model.Customer

interface FindCustomerUseCase {
    fun findCustomerByCpf(cpf: String): Customer?
}