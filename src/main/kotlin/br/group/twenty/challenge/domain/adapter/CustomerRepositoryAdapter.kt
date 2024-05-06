package br.group.twenty.challenge.domain.adapter

import br.group.twenty.challenge.api.dto.CustomerDTO
import br.group.twenty.challenge.domain.repository.CustomerRepository
import br.group.twenty.challenge.domain.repository.CustomerRepositorySpringData

class CustomerRepositoryAdapter(private val customerRepositorySpringData: CustomerRepositorySpringData) :
    CustomerRepository {
    override fun findByCpf(cpf: String): CustomerDTO? {
        try {
            customerRepositorySpringData.findByCpf(cpf)?.apply {
                return CustomerDTO(name = name, email = email, cpf = cpf, id = id_customer)
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}