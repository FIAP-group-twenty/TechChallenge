package br.group.twenty.challenge.infra.adapters.product

import br.group.twenty.challenge.application.port.output.product.UpdateProductOutputPort
import br.group.twenty.challenge.domain.base.ResourceNotFoundException
import br.group.twenty.challenge.domain.models.mapper.ProductMapper.toEntity
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UpdateProductAdapter(private val repository: ProductJpaRepository) : UpdateProductOutputPort {
    override fun updateProduct(id: Int, product: Product): ProductEntity? {
        repository.findByIdProduct(id)?.apply {
            val productUpdate = this.toEntity(product)

            return repository.save(productUpdate)
        }
        throw ResourceNotFoundException("Product not found") //todo: validar se isso aqui ta na camada certa
    }
}