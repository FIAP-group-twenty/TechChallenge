package br.group.twenty.challenge.core.usecases.customer

import br.group.twenty.challenge.core.gateways.ICustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

class GetCustomerUseCase(private val gateway: ICustomerGateway) {
    fun execute(cpf: String): CustomerEntity? {
        return gateway.findCustomerByCpf(cpf)
    }
}