package br.group.twenty.challenge.domain.services.product

import br.group.twenty.challenge.application.port.input.UpdateProductInputPort
import br.group.twenty.challenge.application.port.output.UpdateProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product

class UpdateProductService(
    private val repository: UpdateProductOutputPort
) : UpdateProductInputPort {

    override fun updateProduct(id: Int, product: Product): Product? {
        try {
            val updatedProductEntity = repository.updateProduct(id, product)
            if (updatedProductEntity != null) {
                return Product(
                    id = updatedProductEntity.idProduct,
                    name = updatedProductEntity.name,
                    category = updatedProductEntity.category,
                    price = updatedProductEntity.price,
                    description = updatedProductEntity.description
                )
            }
            return null
        } catch (ex: Exception) {
            throw Exception("Failed to update product with ID: $id", ex)
        }
    }
}