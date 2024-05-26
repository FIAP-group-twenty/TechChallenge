package br.group.twenty.challenge.tech.domain.services.product

import br.group.twenty.challenge.domain.models.enum.CategoryEnum.ACOMPANHAMENTO
import br.group.twenty.challenge.domain.models.enum.CategoryEnum.BEBIDA
import br.group.twenty.challenge.domain.models.enum.CategoryEnum.LANCHE
import br.group.twenty.challenge.domain.models.enum.CategoryEnum.SOBREMESA
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.adapters.product.CreateProductAdapter
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CreateProductAdapterTest {
    private val productJpaRepositoryMock = mockk<ProductJpaRepository>()
    private val createAdapter = CreateProductAdapter(productJpaRepositoryMock)

    @Test
    fun `Should register a product`() {
        val input = Product(name = "Coca-cola", category = BEBIDA.name, description = "zero açucar", price = 5.0)

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 2,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        val output = createAdapter.createProduct(input)

        assertEquals("Coca-cola", output.name)
        assertEquals(BEBIDA, output.category)
        assertEquals("zero açucar", output.description)
        assertEquals(5.0, output.price)
    }

    @Test
    fun `Should throw an error if the category is not valid`() {
        val input = Product(name = "Big Mac", category = "COMBO", description = "inclui batata", price = 20.0)
        val exception = assertThrows<Exception> { createAdapter.createProduct(input) }

        assertEquals(
            "No enum constant br.group.twenty.challenge.domain.models.enum.CategoryEnum.COMBO",
            exception.message
        )
    }

    @Test
    fun `Should throw an error if the name is blank`() {
        val input = Product(name = " ", category = LANCHE.name, description = "veg", price = 15.0)
        val exception = assertThrows<Exception> { createAdapter.createProduct(input) }

        assertEquals("Name cannot be empty", exception.message)
    }

    @Test
    fun `Should throw an error if the description is blank`() {
        val input = Product(name = "Salada", category = ACOMPANHAMENTO.name, description = " ", price = 10.0)
        val exception = assertThrows<Exception> { createAdapter.createProduct(input) }

        assertEquals("Description cannot be empty", exception.message)
    }

    @Test
    fun `Should throw an error if the price equals zero`() {
        val input = Product(name = "Bolo", category = SOBREMESA.name, description = "zero açucar", price = 0.0)
        val exception = assertThrows<Exception> { createAdapter.createProduct(input) }

        assertEquals("Price cannot be 0", exception.message)
    }
}