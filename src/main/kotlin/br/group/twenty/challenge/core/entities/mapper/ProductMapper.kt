package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

object ProductMapper {

    fun Product.updateProduct(dto: Product): ProductEntity {
        return ProductEntity(
            idProduct = dto.id,
            name = dto.name,
            price = dto.price,
            description = dto.description,
            category = dto.category
        )
    }

    fun Product.toEntity(): ProductEntity {
        return ProductEntity(
            idProduct = id,
            name = name,
            price = price,
            description = description,
            category = category
        )
    }

    fun ProductEntity.toDto(): Product {
        return Product(
            id = idProduct,
            name = name,
            category = category,
            price = price,
            description = description,
        )
    }
}