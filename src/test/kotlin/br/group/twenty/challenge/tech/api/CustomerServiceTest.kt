package br.group.twenty.challenge.tech.api

import br.group.twenty.challenge.api.form.CreateCustomerForm
import br.group.twenty.challenge.domain.model.Customer
import br.group.twenty.challenge.domain.repository.CustomerRepository
import br.group.twenty.challenge.domain.service.CustomerService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CustomerServiceTest {
    private val customerRepositoryMock = mockk<CustomerRepository>()
    private val service = CustomerService(customerRepositoryMock)

    @Test
    fun `Should throw an error if the customer already exists`(){
        val input = CreateCustomerForm(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789885")
        every { customerRepositoryMock.findByCpf("42985789885") } returns Customer(1, "luqueta", "lucas@gmail.com", cpf = "42985789885")
        val exception = assertThrows<Exception> {
            service.createCustomer(input)
        }
        assertEquals("customer already exists", exception.message)
    }

    @Test
    fun `Should register a customer`(){
        val input = CreateCustomerForm(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
        every { customerRepositoryMock.findByCpf("42985789886") } returns null
        every { customerRepositoryMock.save(any()) } returns Customer(id_customer = 2, "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
        val output = service.createCustomer(input)
        assertEquals("luqueta", output.name)
        assertEquals("lucas@gmail.com", output.email)
    }
}