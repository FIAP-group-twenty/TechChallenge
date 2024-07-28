package br.group.twenty.challenge.infrastructure.persistence.jpa

import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ICustomerDataSource : JpaRepository<CustomerEntity, Int>{
    fun findByCpf(cpf: String): CustomerEntity?
}