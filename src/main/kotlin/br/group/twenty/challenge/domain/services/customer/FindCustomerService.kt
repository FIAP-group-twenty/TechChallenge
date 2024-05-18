package br.group.twenty.challenge.domain.services.customer

import br.group.twenty.challenge.application.port.input.customer.FindCustomerInputPort
import br.group.twenty.challenge.application.port.output.customer.FindCustomerOutputPort
import br.group.twenty.challenge.domain.models.customer.Customer
import org.springframework.stereotype.Service

@Service
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