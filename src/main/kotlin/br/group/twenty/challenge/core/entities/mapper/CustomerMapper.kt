package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

object CustomerMapper {

    fun CustomerEntity.toDto(): Customer {
        return Customer(
            id = idCustomer,
            name = name,
            email = email,
            cpf = cpf
        )
    }
}