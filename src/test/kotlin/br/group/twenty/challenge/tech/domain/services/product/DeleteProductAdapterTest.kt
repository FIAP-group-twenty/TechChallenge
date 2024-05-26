package br.group.twenty.challenge.tech.domain.services.product

import br.group.twenty.challenge.domain.models.enum.CategoryEnum.BEBIDA
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.adapters.product.CreateProductAdapter
import br.group.twenty.challenge.infra.adapters.product.DeleteProductAdapter
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteProductAdapterTest {
    private val productJpaRepositoryMock = mockk<ProductJpaRepository>()
    private val createAdapter = CreateProductAdapter(productJpaRepositoryMock)
    private val deleteRepository = DeleteProductAdapter(productJpaRepositoryMock)

    @Test
    fun `Should delete product`() {
        val input = Product(name = "Coca-cola", category = BEBIDA.name, description = "zero açucar", price = 5.0)

        every { productJpaRepositoryMock.save(any()) } returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )
        every { productJpaRepositoryMock.findByIdProduct(any()) }returns ProductEntity(
            idProduct = 1,
            name = "Coca-cola",
            category = BEBIDA,
            description = "zero açucar",
            price = 5.0
        )
        every { productJpaRepositoryMock.delete(any()) }.returns(Unit)

        createAdapter.createProduct(input)

        val output = deleteRepository.deleteProduct(1)

        assertEquals(1, output?.idProduct)
    }

    @Test
    fun `Shouldn't delete product`() {
        every { productJpaRepositoryMock.findByIdProduct(any()) }returns null
        every { productJpaRepositoryMock.delete(any()) }.returns(Unit)

        val output = deleteRepository.deleteProduct(1)

        assertEquals(null, output?.idProduct)
    }
}