package br.group.twenty.challenge.api.presenters

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

object ProductPresenter {

    fun formatterProduct(productEntity: ProductEntity?): Product {
        return Product(
            name = productEntity?.name,
            category = productEntity?.category,
            price = productEntity?.price,
            description = productEntity?.description,
            id = productEntity?.idProduct
        )
    }


    fun formatterProductList(products: List<ProductEntity>): List<Product> {
        return products.map { productEntity ->
            formatterProduct(productEntity)
        }
    }
}