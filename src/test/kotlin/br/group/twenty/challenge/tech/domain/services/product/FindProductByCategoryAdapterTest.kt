package br.group.twenty.challenge.tech.domain.services.product

import br.group.twenty.challenge.domain.models.enum.CategoryEnum.ACOMPANHAMENTO
import br.group.twenty.challenge.domain.models.enum.CategoryEnum.BEBIDA
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.adapters.product.CreateProductAdapter
import br.group.twenty.challenge.infra.adapters.product.FindProductAdapter
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindProductByCategoryAdapterTest {
    private val productJpaRepositoryMock = mockk<ProductJpaRepository>()
    private val createAdapter = CreateProductAdapter(productJpaRepositoryMock)
    private val findRepository = FindProductAdapter(productJpaRepositoryMock)

    @Test
    fun `Should find a list of products by category`() {
        val input = Product(name = "Coca-cola", category = BEBIDA.name, description = "zero açucar", price = 5.0)
        val input2 = Product(name = "Salada", category = ACOMPANHAMENTO.name, description = "cezar", price = 10.0)

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 2,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        every { productJpaRepositoryMock.findByCategory(any()) }returns listOf( ProductEntity(
            idProduct = 2,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        ))

        createAdapter.createProduct(input)
        createAdapter.createProduct(input2)

        val output = findRepository.findProductByCategory("BEBIDA")

        assertEquals(1, output.size)
        assertEquals("Coca-cola", output[0].name)
        assertEquals(BEBIDA, output[0].category)
        assertEquals("zero açucar", output[0].description)
        assertEquals(5.0, output[0].price)
    }
}