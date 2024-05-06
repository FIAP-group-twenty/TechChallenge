package br.group.twenty.challenge.domain.service

import br.group.twenty.challenge.api.dto.CustomerDTO
import br.group.twenty.challenge.domain.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class GetCustomerByCpf(private val repository: CustomerRepository) {
    fun execute(cpf: String): CustomerDTO? {
        return repository.findByCpf(cpf)
    }
}