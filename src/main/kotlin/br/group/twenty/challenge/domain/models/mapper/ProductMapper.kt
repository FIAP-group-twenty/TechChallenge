package br.group.twenty.challenge.domain.models.mapper

import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.models.ProductEntity

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

    fun toEntity(dto: Product): ProductEntity {
        return ProductEntity(
            name = dto.name,
            category = dto.category,
            price = dto.price,
            description = dto.description
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
}