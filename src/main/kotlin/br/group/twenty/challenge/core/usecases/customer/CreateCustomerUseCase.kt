package br.group.twenty.challenge.core.usecases.customer

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.core.exceptions.ResourceBusinessException
import br.group.twenty.challenge.infrastructure.gateways.customer.CustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

class CreateCustomerUseCase(private val gateway: CustomerGateway) {

    fun execute(createCustomerModel: CreateCustomer): CustomerEntity {
        gateway.findCustomerByCpf(createCustomerModel.cpf)?.let {
            throw ResourceBusinessException("customer already exists")
        }

        return gateway.createCustomer(createCustomerModel)
    }

}