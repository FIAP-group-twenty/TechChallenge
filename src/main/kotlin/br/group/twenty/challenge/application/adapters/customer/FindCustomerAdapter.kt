package br.group.twenty.challenge.application.adapters.customer

import br.group.twenty.challenge.application.port.input.customer.FindCustomerInputPort
import br.group.twenty.challenge.domain.models.customer.Customer

class FindCustomerAdapter(private val service: FindCustomerInputPort) : FindCustomer {

    override fun findCustomerByCpf(cpf: String): Customer? {
        return service.findCustomerByCpf(cpf)
    }
}