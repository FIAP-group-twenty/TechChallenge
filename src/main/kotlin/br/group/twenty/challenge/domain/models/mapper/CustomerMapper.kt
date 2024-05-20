package br.group.twenty.challenge.domain.models.mapper

import br.group.twenty.challenge.domain.models.customer.Customer
import br.group.twenty.challenge.infra.models.CustomerEntity

object CustomerMapper {

    fun toDTO(entity: CustomerEntity): Customer {
        return Customer(name = entity.name, email = entity.email, cpf = entity.cpf, id = entity.idCustomer)
    }
}