package br.group.twenty.challenge.application.services

import br.group.twenty.challenge.application.usecases.FindCustomerUseCase
import br.group.twenty.challenge.domain.ports.FindCustomerPort
import br.group.twenty.challenge.domain.models.Customer

class FindCustomerService(private val repository: FindCustomerPort) : FindCustomerUseCase {
    override fun findCustomerByCpf(cpf: String): Customer? {
        return repository.findCustomerByCpf(cpf)
    }
}