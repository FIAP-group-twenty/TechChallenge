package br.group.twenty.challenge.infra.data.adapter

import br.group.twenty.challenge.domain.model.Customer
import br.group.twenty.challenge.domain.port.FindCustomerPort
import br.group.twenty.challenge.infra.persistence.repository.CustomerJpaRepository
import org.springframework.stereotype.Repository

@Repository
class FindCustomerAdapter(private val customerJpaRepository: CustomerJpaRepository) :
    FindCustomerPort {

    override fun findCustomerByCpf(cpf: String): Customer? {
        try {
            customerJpaRepository.findByCpf(cpf)?.apply {
                return Customer(name = name, email = email, cpf = cpf, id = id_customer)
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}