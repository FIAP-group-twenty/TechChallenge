package br.group.twenty.challenge.tech.api

import br.group.twenty.challenge.domain.models.CreateCustomer
import br.group.twenty.challenge.infra.models.CustomerEntity
import br.group.twenty.challenge.infra.repositories.CustomerJpaRepository
import br.group.twenty.challenge.application.services.CustomerService
import br.group.twenty.challenge.application.usecases.FindCustomerUseCase
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetCustomerEntityByCpfTest {
    private val customerJpaRepositoryMock = mockk<CustomerJpaRepository>()
    private val service = CustomerService(customerJpaRepositoryMock)
    private val repository = FindCustomerAdapter(customerJpaRepositoryMock)
    private val findCustomerUseCase = FindCustomerUseCase(repository)

    @Test
    fun `Should find a customer`() {
        every { customerJpaRepositoryMock.findByCpf("41596822864") } returns null
        every { customerJpaRepositoryMock.save(any()) } returns CustomerEntity(
            id_customer = 1,
            name = "regina",
            email = "regina@gmail.com",
            cpf = "41596822864"
        )

        service.createCustomer(CreateCustomer(name = "regina", email = "regina@gmail.com", cpf = "41596822864"))
        every { customerJpaRepositoryMock.findByCpf("41596822864") } returns CustomerEntity(
            id_customer = 1,
            name = "regina",
            email = "regina@gmail.com",
            cpf = "41596822864"
        )
        val output = findCustomerUseCase.execute("41596822864")

        assertEquals(1, output?.id)
        assertEquals("regina", output?.name)
        assertEquals("regina@gmail.com", output?.email)
        assertEquals("41596822864", output?.cpf)
    }

    @Test
    fun `Should customer not found`() {
        every { customerJpaRepositoryMock.findByCpf("42985789886") } returns null
        val output = findCustomerUseCase.execute("42985789886")

        assertEquals(null, output)
    }
}