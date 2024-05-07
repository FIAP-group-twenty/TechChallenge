package br.group.twenty.challenge.infra.persistence.repository

import br.group.twenty.challenge.infra.persistence.model.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerJpaRepository : JpaRepository<CustomerEntity, Int> {
    fun findByCpf(cpf: String): CustomerEntity?
}