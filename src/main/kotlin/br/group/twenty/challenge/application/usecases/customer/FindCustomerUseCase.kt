package br.group.twenty.challenge.application.usecases.customer

import br.group.twenty.challenge.domain.models.customer.Customer


interface FindCustomerUseCase {
    fun findCustomerByCpf(cpf: String): Customer?
}