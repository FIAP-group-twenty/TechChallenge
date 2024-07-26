package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

object ProductMapper {

    fun toDTO(entity: ProductEntity): Product {
        return Product(
            name = entity.name,
            category = entity.category,
            price = entity.price,
            description = entity.description,
            id = entity.idProduct
        )
    }

    fun ProductEntity.toEntity(dto: Product): ProductEntity {
        return this.apply {
            name = dto.name
            category = dto.category
            price = dto.price
            description = dto.description
        }
    }

    fun List<ProductEntity>.toProducts(): List<Product> {
        return this.map { productEntity ->
            toDTO(productEntity)
        }
    }
}