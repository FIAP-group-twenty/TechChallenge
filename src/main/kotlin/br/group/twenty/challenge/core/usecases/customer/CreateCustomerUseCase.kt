package br.group.twenty.challenge.core.usecases.customer

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.infrastructure.gateways.customer.CustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

class CreateCustomerUseCase(private val gateway: CustomerGateway, private val getCustomerUseCase: GetCustomerUseCase) {

    fun execute(createCustomerModel: CreateCustomer): CustomerEntity {
        getCustomerUseCase.execute(createCustomerModel.cpf)?.let {
            throw Exception("customer already exists")
        }

        return gateway.createCustomer(createCustomerModel)
    }

}