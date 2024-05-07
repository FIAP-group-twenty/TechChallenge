package br.group.twenty.challenge.infra.adapters

import br.group.twenty.challenge.domain.models.Customer
import br.group.twenty.challenge.domain.ports.FindCustomerPort
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
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