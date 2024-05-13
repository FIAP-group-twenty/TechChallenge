package br.group.twenty.challenge.infra.repositories

import br.group.twenty.challenge.infra.models.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerJpaRepository : JpaRepository<CustomerEntity, Int> {
    fun findByCpf(cpf: String): CustomerEntity?
}