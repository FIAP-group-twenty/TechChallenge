package br.group.twenty.challenge.domain.services

import br.group.twenty.challenge.application.port.input.CreateCustomerInputPort
import br.group.twenty.challenge.application.port.output.CreateCustomerOutputPort
import br.group.twenty.challenge.application.port.output.FindCustomerOutputPort
import br.group.twenty.challenge.domain.models.CreateCustomerModel
import br.group.twenty.challenge.domain.models.Customer

class CreateCustomerService(
    private val repository: CreateCustomerOutputPort,
    private val findRepository: FindCustomerOutputPort
) : CreateCustomerInputPort {

    override fun createCustomer(createCustomerModel: CreateCustomerModel): Customer {
        if (findRepository.findCustomerByCpf(createCustomerModel.cpf) != null)
            throw Exception("customer already exists")

        repository.createCustomer(createCustomerModel).apply {
            return Customer(name = name, email = email, cpf = cpf, id = idCustomer)
        }
    }
}