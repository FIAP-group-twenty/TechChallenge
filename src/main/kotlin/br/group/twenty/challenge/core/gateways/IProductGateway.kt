package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

interface IProductGateway {
    fun createProduct(product: Product): ProductEntity
    fun deleteProduct(product: ProductEntity): ProductEntity
    fun findProductById(id: Int): ProductEntity
    fun findProductByCategory(category: String): List<ProductEntity>
    fun updateProduct(oldProduct: ProductEntity, product: Product): ProductEntity
}