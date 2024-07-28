package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

object ProductMapper {

    fun ProductEntity.toEntity(dto: Product): ProductEntity {
        return this.apply {
            name = dto.name
            category = dto.category
            price = dto.price
            description = dto.description
        }
    }
}