package br.group.twenty.challenge.application.adapters.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomerModel
import br.group.twenty.challenge.domain.models.customer.Customer
import org.springframework.context.annotation.Configuration

interface CreateCustomer {
    fun createCustomer(createCustomerModel: CreateCustomerModel): Customer
}