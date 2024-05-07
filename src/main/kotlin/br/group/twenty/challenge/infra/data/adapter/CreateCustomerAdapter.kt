package br.group.twenty.challenge.infra.data.adapter

import br.group.twenty.challenge.infra.data.model.CreateCustomer
import br.group.twenty.challenge.domain.port.CreateCustomerPort
import br.group.twenty.challenge.domain.model.Customer
import br.group.twenty.challenge.infra.persistence.model.CustomerEntity
import br.group.twenty.challenge.infra.persistence.repository.CustomerJpaRepository
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