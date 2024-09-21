package br.group.twenty.challenge.core.usecases.customer

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.core.exceptions.ResourceBusinessException
import br.group.twenty.challenge.core.gateways.ICustomerGateway
import br.group.twenty.challenge.infrastructure.gateways.customer.CustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

class CreateCustomerUseCase(private val gateway: ICustomerGateway) {

    fun execute(createCustomerModel: CreateCustomer): Customer {
        gateway.findCustomerByCpf(createCustomerModel.cpf)?.let {
            throw ResourceBusinessException("customer already exists")
        }

        return gateway.createCustomer(createCustomerModel)
    }

}