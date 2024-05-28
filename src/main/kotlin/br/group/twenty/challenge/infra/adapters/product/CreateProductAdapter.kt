package br.group.twenty.challenge.infra.adapters.product

import br.group.twenty.challenge.application.port.output.product.CreateProductOutputPort
import br.group.twenty.challenge.domain.models.enum.CategoryEnum
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
                category = product.category?.let { CategoryEnum.valueOf(it) },
                price = product.price,
                description = product.description
            )
        )
    }
}