package br.group.twenty.challenge.infrastructure.gateways.customer

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.core.gateways.ICustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.ICustomerDataSource
import org.springframework.stereotype.Repository

@Repository
class CustomerGateway(private val dataSource: ICustomerDataSource) : ICustomerGateway {

    override fun createCustomer(createCustomerModel: CreateCustomer): CustomerEntity {
        try {
            return dataSource.save(
                CustomerEntity(
                    name = createCustomerModel.name,
                    cpf = createCustomerModel.cpf,
                    email = createCustomerModel.email
                )
            )
        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun findCustomerByCpf(cpf: String): CustomerEntity? {
        try {
            return dataSource.findByCpf(cpf)
        } catch (ex: Exception) {
            throw ex
        }
    }

}