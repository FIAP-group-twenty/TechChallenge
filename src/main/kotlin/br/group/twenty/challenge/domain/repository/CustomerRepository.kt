package br.group.twenty.challenge.domain.repository

import br.group.twenty.challenge.api.dto.CustomerDTO

interface CustomerRepository {
    fun findByCpf(cpf: String): CustomerDTO?
}