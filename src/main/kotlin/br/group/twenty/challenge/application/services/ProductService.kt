package br.group.twenty.challenge.application.services

import br.group.twenty.challenge.application.usecases.product.CreateProductUseCase
import br.group.twenty.challenge.application.usecases.product.DeleteProductUseCase
import br.group.twenty.challenge.application.usecases.product.FindProductUseCase
import br.group.twenty.challenge.application.usecases.product.UpdateProductUseCase
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.domain.ports.ProductPort

class ProductService(
    private val repository: ProductPort
) : CreateProductUseCase, FindProductUseCase, UpdateProductUseCase, DeleteProductUseCase {

    override fun createProduct(productRequest: Product): Product {
        try {
            repository.createProduct(productRequest).apply {
                return Product(idProduct, name, category?.name, price, description)
            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }

    override fun findProductById(id: Int): Product? {
        try {
            repository.findProductById(id)?.apply {
                return Product(this.idProduct, name, category?.name, price, description)
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
                updatedProductEntity.category?.name,
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
                    return Product(this!!.idProduct, name, category?.name, price, description)
                }
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}