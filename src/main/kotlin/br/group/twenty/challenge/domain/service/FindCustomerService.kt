package br.group.twenty.challenge.domain.service

import br.group.twenty.challenge.domain.usecase.FindCustomerUseCase
import br.group.twenty.challenge.domain.port.FindCustomerPort
import br.group.twenty.challenge.domain.model.Customer

class FindCustomerService(private val repository: FindCustomerPort) : FindCustomerUseCase {
    override fun findCustomerByCpf(cpf: String): Customer? {
        return repository.findCustomerByCpf(cpf)
    }
}