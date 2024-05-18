package br.group.twenty.challenge.infra.adapters

import br.group.twenty.challenge.application.port.output.DeleteProductOutputPort
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class DeleteProductAdapter(private val repository: ProductJpaRepository) : DeleteProductOutputPort {
    override fun deleteProduct(id: Int): ProductEntity? {
        val existingProduct = repository.findByIdProduct(id)

        existingProduct?.let { repository.delete(it) }

        return existingProduct
    }
}
