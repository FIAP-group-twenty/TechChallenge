package br.group.twenty.challenge.infra.adapters

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.domain.ports.CustomerPort
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CustomerAdapter(private val repository: CustomerJpaRepository) :
    CustomerPort {

    override fun createCustomer(createCustomer: CreateCustomer): CustomerEntity {
        return repository.save(
            CustomerEntity(
                name = createCustomer.name,
                cpf = createCustomer.cpf,
                email = createCustomer.email
            )
        )
    }

    override fun findCustomerByCpf(cpf: String): CustomerEntity? {
        return repository.findByCpf(cpf)
    }

}