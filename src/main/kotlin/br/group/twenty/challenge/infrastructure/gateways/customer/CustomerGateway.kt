package br.group.twenty.challenge.infrastructure.gateways.customer

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.core.entities.customer.Customer
import br.group.twenty.challenge.core.entities.mapper.CustomerMapper.toDto
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.ICustomerGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.ICustomerDataSource
import org.springframework.stereotype.Repository

@Repository
class CustomerGateway(private val dataSource: ICustomerDataSource) : ICustomerGateway {

    override fun createCustomer(createCustomerModel: CreateCustomer): Customer {
        try {
            val result = dataSource.save(
                CustomerEntity(
                    name = createCustomerModel.name,
                    cpf = createCustomerModel.cpf,
                    email = createCustomerModel.email
                )
            )

            return result.toDto()

        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to create customer ${createCustomerModel.name}.", ex)
        }
    }

    override fun findCustomerByCpf(cpf: String): Customer? {
        try {
            return dataSource.findByCpf(cpf)?.toDto()
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find customer $cpf.", ex)
        }
    }

}