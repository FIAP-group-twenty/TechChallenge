package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity

object CustomerMapper {

    fun toDTO(entity: CustomerEntity): Customer {
        return Customer(name = entity.name, email = entity.email, cpf = entity.cpf, id = entity.idCustomer)
    }
}