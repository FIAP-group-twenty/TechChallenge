package br.group.twenty.challenge.infra.adapters.customer

import br.group.twenty.challenge.application.port.output.customer.FindCustomerOutputPort
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import org.springframework.stereotype.Repository

@Repository
class FindCustomerAdapter(private val repository: CustomerJpaRepository) : FindCustomerOutputPort {

    override fun findCustomerByCpf(cpf: String): CustomerEntity? {
        return repository.findByCpf(cpf)
    }
}