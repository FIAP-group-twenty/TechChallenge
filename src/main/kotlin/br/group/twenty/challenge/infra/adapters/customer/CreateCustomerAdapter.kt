package br.group.twenty.challenge.infra.adapters.customer

import br.group.twenty.challenge.application.port.output.customer.CreateCustomerOutputPort
import br.group.twenty.challenge.domain.models.customer.CreateCustomerModel
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CreateCustomerAdapter(private val repository: CustomerJpaRepository) : CreateCustomerOutputPort {

    override fun createCustomer(createCustomerModel: CreateCustomerModel): CustomerEntity {
        return repository.save(
            CustomerEntity(
                name = createCustomerModel.name,
                cpf = createCustomerModel.cpf,
                email = createCustomerModel.email
            )
        )
    }
}