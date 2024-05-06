package br.group.twenty.challenge.tech.api

import br.group.twenty.challenge.api.form.CreateCustomerForm
import br.group.twenty.challenge.domain.adapter.CustomerRepositoryAdapter
import br.group.twenty.challenge.domain.model.Customer
import br.group.twenty.challenge.domain.repository.CustomerRepositorySpringData
import br.group.twenty.challenge.domain.service.CustomerService
import br.group.twenty.challenge.domain.service.GetCustomerByCpf
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetCustomerByCpfTest {
    private val customerRepositorySpringDataMock = mockk<CustomerRepositorySpringData>()
    private val service = CustomerService(customerRepositorySpringDataMock)
    private val repository = CustomerRepositoryAdapter(customerRepositorySpringDataMock)
    private val getCustomerByCpf = GetCustomerByCpf(repository)

    @Test
    fun `Should find a customer`() {
        every { customerRepositorySpringDataMock.findByCpf("41596822864") } returns null
        every { customerRepositorySpringDataMock.save(any()) } returns Customer(
            id_customer = 1,
            name = "regina",
            email = "regina@gmail.com",
            cpf = "41596822864"
        )

        service.createCustomer(CreateCustomerForm(name = "regina", email = "regina@gmail.com", cpf = "41596822864"))
        every { customerRepositorySpringDataMock.findByCpf("41596822864") } returns Customer(
            id_customer = 1,
            name = "regina",
            email = "regina@gmail.com",
            cpf = "41596822864"
        )
        val output = getCustomerByCpf.execute("41596822864")

        assertEquals(1, output?.id)
        assertEquals("regina", output?.name)
        assertEquals("regina@gmail.com", output?.email)
        assertEquals("41596822864", output?.cpf)
    }

    @Test
    fun `Should customer not found`() {
        every { customerRepositorySpringDataMock.findByCpf("42985789886") } returns null
        val output = getCustomerByCpf.execute("42985789886")

        assertEquals(null, output)
    }
}