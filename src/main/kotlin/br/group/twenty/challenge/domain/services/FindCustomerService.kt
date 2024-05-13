package br.group.twenty.challenge.domain.services

import br.group.twenty.challenge.application.port.input.FindCustomerInputPort
import br.group.twenty.challenge.application.port.output.FindCustomerOutputPort
import br.group.twenty.challenge.domain.models.Customer

class FindCustomerService(
    private val repository: FindCustomerOutputPort
) : FindCustomerInputPort {

    override fun findCustomerByCpf(cpf: String): Customer? {
        try {
            repository.findCustomerByCpf(cpf)?.apply {
                return Customer(name = name, email = email, cpf = cpf, id = idCustomer)
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}