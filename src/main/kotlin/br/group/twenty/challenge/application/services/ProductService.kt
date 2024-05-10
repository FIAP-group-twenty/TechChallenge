package br.group.twenty.challenge.application.services

import br.group.twenty.challenge.application.usecases.FindProductUseCase
import br.group.twenty.challenge.application.usecases.UpdateProductUseCase
import br.group.twenty.challenge.domain.models.Product
import br.group.twenty.challenge.domain.ports.ProductPort

class ProductService(
    private val repository: ProductPort
) : FindProductUseCase, UpdateProductUseCase {

    override fun findProductById(id: Int): Product? {
        try {
            repository.findProductById(id)?.apply {
                return Product(name = name, category = category, price = price, description = description, id = idProduct)
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }

    override fun updateProduct(id: Int, updatedProduct: Product): Product? {
        if (repository.findProductById(id) != null) {
            val updatedProductEntity = repository.updateProduct(id, updatedProduct)
            return Product(
                id = updatedProductEntity.idProduct,
                name = updatedProductEntity.name,
                category = updatedProductEntity.category,
                price = updatedProductEntity.price,
                description = updatedProductEntity.description
            )
        } else {
            return null
        }
    }
}