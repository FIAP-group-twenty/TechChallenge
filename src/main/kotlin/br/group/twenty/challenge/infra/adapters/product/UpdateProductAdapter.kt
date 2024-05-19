package br.group.twenty.challenge.infra.adapters.product

import br.group.twenty.challenge.application.port.output.product.UpdateProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UpdateProductAdapter(private val repository: ProductJpaRepository) : UpdateProductOutputPort {
    override fun updateProduct(id: Int, updatedProduct: Product): ProductEntity? {
        val existingProduct = repository.findByIdProduct(id)
        if (existingProduct != null) {
            // Update the fields of the existing product with the new values
            existingProduct.apply {
                name = updatedProduct.name
                category = updatedProduct.category
                price = updatedProduct.price
                description = updatedProduct.description
            }
            // Save the updated product in the database
            return repository.save(existingProduct)
        } else {
            // If the product with the provided ID doesn't exist, return null
            return null
        }
    }
}