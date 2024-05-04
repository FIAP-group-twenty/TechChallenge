package br.group.twenty.challenge.domain.repository

import br.group.twenty.challenge.domain.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Int> {
    fun findByCpf(cpf: String): Customer?
}