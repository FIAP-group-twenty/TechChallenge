package br.group.twenty.challenge.application.services

import br.group.twenty.challenge.application.usecases.customer.CreateCustomerUseCase
import br.group.twenty.challenge.application.usecases.customer.FindCustomerUseCase
import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.domain.models.customer.Customer
import br.group.twenty.challenge.domain.ports.CustomerPort

class CustomerService(
    private val repository: CustomerPort
) : CreateCustomerUseCase, FindCustomerUseCase {

    override fun createCustomer(createCustomer: CreateCustomer): Customer {
        if (repository.findCustomerByCpf(createCustomer.cpf) != null)
            throw Exception("customer already exists")

         repository.createCustomer(createCustomer).apply {
             return Customer(name = name, email = email, cpf = cpf, id = idCustomer)
         }
    }

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