package br.group.twenty.challenge.tech.api

import br.group.twenty.challenge.infra.data.model.CreateCustomer
import br.group.twenty.challenge.infra.persistence.model.CustomerEntity
import br.group.twenty.challenge.infra.persistence.repository.CustomerJpaRepository
import br.group.twenty.challenge.domain.service.CustomerService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class CustomerEntityServiceTest {
    private val customerJpaRepositoryMock = mockk<CustomerJpaRepository>()
    private val service = CustomerService(customerJpaRepositoryMock)

    @Test
    fun `Should throw an error if the customer already exists`(){
        val input = CreateCustomer(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789885")
        every { customerJpaRepositoryMock.findByCpf("42985789885") } returns CustomerEntity(1, "luqueta", "lucas@gmail.com", cpf = "42985789885")
        val exception = assertThrows<Exception> {
            service.createCustomer(input)
        }
        assertEquals("customer already exists", exception.message)
    }

    @Test
    fun `Should register a customer`(){
        val input = CreateCustomer(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
        every { customerJpaRepositoryMock.findByCpf("42985789886") } returns null
        every { customerJpaRepositoryMock.save(any()) } returns CustomerEntity(id_customer = 2, "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
        val output = service.createCustomer(input)
        assertEquals("luqueta", output.name)
        assertEquals("lucas@gmail.com", output.email)
    }
}