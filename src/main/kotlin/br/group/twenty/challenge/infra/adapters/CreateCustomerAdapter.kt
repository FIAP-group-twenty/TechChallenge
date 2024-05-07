package br.group.twenty.challenge.infra.adapters

import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.domain.ports.CreateCustomerPort
import br.group.twenty.challenge.domain.models.Customer
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CreateCustomerAdapter(private val repository: CustomerJpaRepository) :
    CreateCustomerPort {

    override fun createCustomer(createCustomer: CreateCustomer): Customer {
        if (repository.findByCpf(createCustomer.cpf) != null)
            throw Exception("customer already exists")

        repository.save(
            CustomerEntity(
                name = createCustomer.name,
                cpf = createCustomer.cpf,
                email = createCustomer.email
            )
        )
        return Customer(name = createCustomer.name, email = createCustomer.email, cpf = createCustomer.cpf)
    }

}