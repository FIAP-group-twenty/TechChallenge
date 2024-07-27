package br.group.twenty.challenge.tech.domain.services

import br.group.twenty.challenge.core.entities.customer.CreateCustomer
import br.group.twenty.challenge.infrastructure.gateways.customer.CustomerGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.CustomerEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.ICustomerDataSource
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CreateCustomerUseCaseTest {
    private val customerJpaRepositoryMock = mockk<ICustomerDataSource>()
    private val createAdapter = CustomerGateway(customerJpaRepositoryMock)

//    @Test
//    fun `Should throw an error if the customer already exists`() {
//        val input = CreateCustomer(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789885")
//        every { customerJpaRepositoryMock.findByCpf("42985789885") } returns CustomerEntity(
//            1,
//            "luqueta",
//            "lucas@gmail.com",
//            cpf = "42985789885"
//        )
//        val exception = assertThrows<Exception> {
//            createAdapter.createCustomer(input)
//        }
//        assertEquals(
//            "no answer found for: CustomerJpaRepository(#1).save(CustomerEntity(idCustomer=null, name=luqueta, email=lucas@gmail.com, cpf=42985789885))",
//            exception.message
//        )
//    }
//
//    @Test
//    fun `Should register a customer`() {
//        val input = CreateCustomer(name = "luqueta", email = "lucas@gmail.com", cpf = "42985789886")
//        every { customerJpaRepositoryMock.findByCpf("42985789886") } returns null
//        every { customerJpaRepositoryMock.save(any()) } returns CustomerEntity(
//            idCustomer = 2,
//            "luqueta",
//            email = "lucas@gmail.com",
//            cpf = "42985789886"
//        )
//        val output = createAdapter.createCustomer(input)
//        assertEquals("luqueta", output.name)
//        assertEquals("lucas@gmail.com", output.email)
//    }
}