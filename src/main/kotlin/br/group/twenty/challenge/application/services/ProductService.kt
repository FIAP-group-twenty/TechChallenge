package br.group.twenty.challenge.application.services

import br.group.twenty.challenge.application.usecases.CreateProductUseCase
import br.group.twenty.challenge.application.usecases.DeleteProductUseCase
import br.group.twenty.challenge.application.usecases.FindProductUseCase
import br.group.twenty.challenge.application.usecases.UpdateProductUseCase
import br.group.twenty.challenge.domain.models.Product
import br.group.twenty.challenge.domain.ports.ProductPort

class ProductService(
    private val repository: ProductPort
) : CreateProductUseCase, FindProductUseCase, UpdateProductUseCase, DeleteProductUseCase {

    override fun createProduct(productRequest: Product): Product {
        try {
            repository.createProduct(productRequest).apply {
                return Product(idProduct, name, category, price, description)
            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }

    override fun findProductById(id: Int): Product? {
        try {
            repository.findProductById(id)?.apply {
                return Product(this.idProduct, name, category, price, description)
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
                updatedProductEntity!!.idProduct,
                updatedProductEntity.name,
                updatedProductEntity.category,
                updatedProductEntity.price,
                updatedProductEntity.description
            )
        } else {
            return null
        }
    }

    override fun deleteProduct(id: Int): Product? {
        try {
            repository.findProductById(id)?.apply {
                repository.deleteProduct(id).apply {
                    return Product(this!!.idProduct, name, category, price, description)
                }
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}