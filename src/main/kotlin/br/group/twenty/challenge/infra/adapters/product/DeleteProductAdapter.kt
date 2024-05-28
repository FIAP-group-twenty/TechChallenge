package br.group.twenty.challenge.infra.adapters.product

import br.group.twenty.challenge.application.port.output.product.DeleteProductOutputPort
import br.group.twenty.challenge.domain.base.ResourceNotFoundException
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class DeleteProductAdapter(private val repository: ProductJpaRepository) : DeleteProductOutputPort {
    override fun deleteProduct(id: Int): ProductEntity? {
        val existingProduct = repository.findByIdProduct(id)

         existingProduct?.let { repository.delete(it) } ?: throw ResourceNotFoundException("Product not found")

        return existingProduct
    }
}
