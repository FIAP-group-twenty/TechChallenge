package br.group.twenty.challenge.api.presenters

import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

object CustomerPresenter {
    fun formatter(entity: CustomerEntity?, cpf: String): Customer {
        entity?.let { itCustomer ->
            return Customer(
                name = itCustomer.name,
                email = itCustomer.email,
                cpf = itCustomer.cpf,
                id = itCustomer.idCustomer
            )
        }

        throw ResourceNotFoundException("Customer not found for CPF: $cpf")

    }
}