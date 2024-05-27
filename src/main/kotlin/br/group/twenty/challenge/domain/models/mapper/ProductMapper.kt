package br.group.twenty.challenge.domain.models.mapper

import br.group.twenty.challenge.domain.models.enum.CategoryEnum
import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.models.ProductEntity

object ProductMapper {

    fun toDTO(entity: ProductEntity): Product {
        return Product(
            name = entity.name,
            category = entity.category?.name,
            price = entity.price,
            description = entity.description,
            id = entity.idProduct
        )
    }

    fun ProductEntity.toEntity(dto: Product): ProductEntity {
        return this.apply {
            name = dto.name ?: this.name
            category = dto.category?.let { CategoryEnum.valueOf(it) } ?: this.category
            price = dto.price ?: this.price
            description = dto.description ?: this.description
        }
    }

    fun List<ProductEntity>.toProducts(): List<Product> {
        return this.map { productEntity ->
            toDTO(productEntity)
        }
    }
}