package br.group.twenty.challenge.domain.repository

import br.group.twenty.challenge.domain.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepositorySpringData : JpaRepository<Customer, Int> {
    fun findByCpf(cpf: String): Customer?
}