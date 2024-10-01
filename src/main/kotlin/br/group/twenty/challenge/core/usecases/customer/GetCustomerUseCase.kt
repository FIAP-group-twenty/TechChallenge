package br.group.twenty.challenge.core.usecases.customer

import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.ICustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

class GetCustomerUseCase(private val gateway: ICustomerGateway) {
    fun execute(cpf: String): Customer {
        return gateway.findCustomerByCpf(cpf) ?: throw ResourceNotFoundException("Customer not found")
    }
}