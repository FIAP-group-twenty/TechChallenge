package br.group.twenty.challenge.tech.domain.services.product

import br.group.twenty.challenge.domain.models.enum.CategoryEnum.BEBIDA
import br.group.twenty.challenge.domain.models.enum.CategoryEnum.SOBREMESA
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.adapters.product.UpdateProductAdapter
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UpdateProductAdapterTest {
    private val productJpaRepositoryMock = mockk<ProductJpaRepository>()
    private val updateAdapter = UpdateProductAdapter(productJpaRepositoryMock)

    @Test
    fun `Should update a product name`() {
        val input = Product(name = "Sprite")

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Sprite",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )
        every { productJpaRepositoryMock.findByIdProduct(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        val output = updateAdapter.updateProduct(1, input)

        assertEquals("Sprite", output?.name)
        assertEquals(BEBIDA, output?.category)
        assertEquals("zero açucar", output?.description)
        assertEquals(5.0, output?.price)
    }

    @Test
    fun `Should update a product category`() {
        val input = Product(category = SOBREMESA.name)

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = SOBREMESA,
            description = "zero açucar",
            price = 5.0
        )
        every { productJpaRepositoryMock.findByIdProduct(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        val output = updateAdapter.updateProduct(1, input)

        assertEquals("Coca-cola", output?.name)
        assertEquals(SOBREMESA, output?.category)
        assertEquals("zero açucar", output?.description)
        assertEquals(5.0, output?.price)
    }

    @Test
    fun `Should update a product description`() {
        val input = Product(description = "normal")

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "normal",
            price = 5.0
        )
        every { productJpaRepositoryMock.findByIdProduct(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        val output = updateAdapter.updateProduct(1, input)

        assertEquals("Coca-cola", output?.name)
        assertEquals(BEBIDA, output?.category)
        assertEquals("normal", output?.description)
        assertEquals(5.0, output?.price)
    }

    @Test
    fun `Should update a product price`() {
        val input = Product(price = 3.0)

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 3.0
        )
        every { productJpaRepositoryMock.findByIdProduct(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        val output = updateAdapter.updateProduct(1, input)

        assertEquals("Coca-cola", output?.name)
        assertEquals(BEBIDA, output?.category)
        assertEquals("zero açucar", output?.description)
        assertEquals(3.0, output?.price)
    }

    @Test
    fun `Should update a product name and price`() {
        val input = Product(name = "Sprite", price = 3.0)

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Sprite",
            category = BEBIDA,
            description = "zero açucar",
            price = 3.0
        )
        every { productJpaRepositoryMock.findByIdProduct(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )

        val output = updateAdapter.updateProduct(1, input)

        assertEquals("Sprite", output?.name)
        assertEquals(BEBIDA, output?.category)
        assertEquals("zero açucar", output?.description)
        assertEquals(3.0, output?.price)
    }

    @Test
    fun `Shouldn't update a product because it doesn't exist`() {
        val input = Product(category = SOBREMESA.name)

        every { productJpaRepositoryMock.findByIdProduct(any()) } returns null

        val exception = assertThrows<Exception> { updateAdapter.updateProduct(1, input) }

        assertEquals("Product not found", exception.message)
    }
}