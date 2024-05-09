package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.application.port.input.FindCustomerInputPort
import br.group.twenty.challenge.domain.models.Customer

class FindCustomerAdapter(private val service: FindCustomerInputPort) : FindCustomer {

    override fun findCustomerByCpf(cpf: String): Customer? {
        return service.findCustomerByCpf(cpf)
    }
}