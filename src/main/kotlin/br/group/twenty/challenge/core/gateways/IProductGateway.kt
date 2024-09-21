package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

interface IProductGateway {
    fun createProduct(product: Product): Product
    fun deleteProduct(product: Product): Product
    fun findProductById(id: Int): Product
    fun findProductByCategory(category: String): List<Product>
    fun updateProduct(oldProduct: Product, product: Product): Product
}