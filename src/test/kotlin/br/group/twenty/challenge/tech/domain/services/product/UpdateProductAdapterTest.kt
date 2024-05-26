package br.group.twenty.challenge.tech.domain.services.product

import br.group.twenty.challenge.infra.adapters.product.CreateProductAdapter
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import io.mockk.mockk
import org.junit.jupiter.api.Test

class UpdateProductAdapterTest {
    private val productJpaRepositoryMock = mockk<ProductJpaRepository>()
    private val createAdapter = CreateProductAdapter(productJpaRepositoryMock)

    @Test
    fun `Should update a product name`() {}

    @Test
    fun `Should update a product category`() {}

    @Test
    fun `Should update a product description`() {}

    @Test
    fun `Should update a product price`() {}

    @Test
    fun `Should update a product name and price`() {}

    @Test
    fun `Shouldn't update a product because it doesn't exist`() {}
}