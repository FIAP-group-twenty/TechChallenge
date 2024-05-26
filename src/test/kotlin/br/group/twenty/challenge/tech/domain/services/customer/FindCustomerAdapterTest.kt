package br.group.twenty.challenge.tech.domain.services.customer

import br.group.twenty.challenge.domain.models.customer.CreateCustomer
import br.group.twenty.challenge.infra.adapters.customer.CreateCustomerAdapter
import br.group.twenty.challenge.infra.adapters.customer.FindCustomerAdapter
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindCustomerAdapterTest {
    private val customerJpaRepositoryMock = mockk<CustomerJpaRepository>()
    private val createAdapter = CreateCustomerAdapter(customerJpaRepositoryMock)
    private val findRepository = FindCustomerAdapter(customerJpaRepositoryMock)

    @Test
    fun `Should find a customer`() {
        every { customerJpaRepositoryMock.findByCpf("41596822864") } returns null
        every { customerJpaRepositoryMock.save(any()) } returns CustomerEntity(
            idCustomer = 1,
            name = "regina",
            email = "regina@gmail.com",
            cpf = "41596822864"
        )

        createAdapter.createCustomer(CreateCustomer(name = "regina", email = "regina@gmail.com", cpf = "41596822864"))
        every { customerJpaRepositoryMock.findByCpf("41596822864") } returns CustomerEntity(
            idCustomer = 1,
            name = "regina",
            email = "regina@gmail.com",
            cpf = "41596822864"
        )
        val output = findRepository.findCustomerByCpf("41596822864")

        assertEquals(1, output?.idCustomer)
        assertEquals("regina", output?.name)
        assertEquals("regina@gmail.com", output?.email)
        assertEquals("41596822864", output?.cpf)
    }

    @Test
    fun `Should customer not found`() {
        every { customerJpaRepositoryMock.findByCpf("42985789886") } returns null
        val output = findRepository.findCustomerByCpf("42985789886")
        assertEquals(null, output)
    }
}