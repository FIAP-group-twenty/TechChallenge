package br.group.twenty.challenge.domain.services.customer

import br.group.twenty.challenge.application.port.input.customer.FindCustomerInputPort
import br.group.twenty.challenge.application.port.output.customer.FindCustomerOutputPort
import br.group.twenty.challenge.domain.base.ResourceNotFoundException
import br.group.twenty.challenge.domain.models.customer.Customer
import br.group.twenty.challenge.domain.models.mapper.CustomerMapper
import org.springframework.stereotype.Service

@Service
class FindCustomerService(
    private val repository: FindCustomerOutputPort
) : FindCustomerInputPort {

    override fun findCustomerByCpf(cpf: String): Customer {
        try {
            repository.findCustomerByCpf(cpf)?.apply {
                return CustomerMapper.toDTO(this)
            }
            throw ResourceNotFoundException("Customer not found for CPF: $cpf")

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}