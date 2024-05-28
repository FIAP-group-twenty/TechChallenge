package br.group.twenty.challenge.tech.domain.services

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.infra.adapters.customer.CreateCustomerAdapter
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CreateCustomerAdapterTest {
    private val customerJpaRepositoryMock = mockk<CustomerJpaRepository>()
    private val createAdapter = CreateCustomerAdapter(customerJpaRepositoryMock)

    @Test
    fun `Should throw an error if the customer already exists`(){
        val input = CreateCustomer(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789885")
        every { customerJpaRepositoryMock.findByCpf("42985789885") } returns CustomerEntity(1, "luqueta", "lucas@gmail.com", cpf = "42985789885")
        val exception = assertThrows<Exception> {
            createAdapter.createCustomer(input)
        }
        assertEquals("no answer found for: CustomerJpaRepository(#1).save(CustomerEntity(idCustomer=null, name=luqueta, email=lucas@gmail.com, cpf=42985789885))", exception.message)
    }

    @Test
    fun `Should register a customer`(){
        val input = CreateCustomer(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
        every { customerJpaRepositoryMock.findByCpf("42985789886") } returns null
        every { customerJpaRepositoryMock.save(any()) } returns CustomerEntity(idCustomer = 2, "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
        val output = createAdapter.createCustomer(input)
        assertEquals("luqueta", output.name)
        assertEquals("lucas@gmail.com", output.email)
    }
}