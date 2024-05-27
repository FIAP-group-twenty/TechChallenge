package br.group.twenty.challenge.tech.domain.services

import br.group.twenty.challenge.infra.adapters.order.FindListOfOrdersAdapter
import br.group.twenty.challenge.infra.models.OrderEntity
import br.group.twenty.challenge.infra.repositories.OrderJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDateTime

class FindListOfOrdersAdapterTest{
    private val findListOfOrdersServiceMock = mockk<OrderJpaRepository>()
    private val findListOfOrdersAdapter = FindListOfOrdersAdapter(findListOfOrdersServiceMock)

    @Test
    fun `Should return a list of orders`() {
        val orders = listOf(
            OrderEntity(
                idOrder = 1,
                orderValue = BigDecimal("100.00"),
                idCustomer = 1,
                creationOrder = LocalDateTime.now(),
                lastUpdateOrder = LocalDateTime.now(),
                status = "PENDING"
            ),
            OrderEntity(
                idOrder = 2,
                orderValue = BigDecimal("200.00"),
                idCustomer = 2,
                creationOrder = LocalDateTime.now(),
                lastUpdateOrder = LocalDateTime.now(),
                status = "COMPLETED"
            )
        )

        every { findListOfOrdersServiceMock.findAll() } returns orders

        val result = findListOfOrdersAdapter.findListOfOrders()
        assertEquals(orders, result)
    }
}