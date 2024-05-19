package br.group.twenty.challenge.infra.adapters

import br.group.twenty.challenge.application.port.output.CreateProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CreateProductAdapter(private val repository: ProductJpaRepository) : CreateProductOutputPort {
    override fun createProduct(product: Product): ProductEntity {
        return repository.save(
            ProductEntity(
                name = product.name,
                category = product.category,
                price = product.price,
                description = product.description
            )
        )
    }
}