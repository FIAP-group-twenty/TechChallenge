package br.group.twenty.challenge.domain.services.customer

import br.group.twenty.challenge.application.port.input.customer.CreateCustomerInputPort
import br.group.twenty.challenge.application.port.output.customer.CreateCustomerOutputPort
import br.group.twenty.challenge.application.port.output.customer.FindCustomerOutputPort
import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.domain.models.customer.Customer

class CreateCustomerService(
    private val repository: CreateCustomerOutputPort,
    private val findRepository: FindCustomerOutputPort
) : CreateCustomerInputPort {

    override fun createCustomer(createCustomerModel: CreateCustomer): Customer {
        if (findRepository.findCustomerByCpf(createCustomerModel.cpf) != null)
            throw Exception("customer already exists")

        repository.createCustomer(createCustomerModel).apply {
            return Customer(name = name, email = email, cpf = cpf, id = idCustomer)
        }
    }
}