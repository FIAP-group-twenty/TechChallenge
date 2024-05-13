package br.group.twenty.challenge.application.usecases

import br.group.twenty.challenge.domain.models.Customer

interface FindCustomerUseCase {
    fun findCustomerByCpf(cpf: String): Customer?
}