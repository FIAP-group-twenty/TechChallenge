package br.group.twenty.challenge.domain.ports

import br.group.twenty.challenge.domain.models.Product
import br.group.twenty.challenge.infra.models.ProductEntity

interface ProductPort {
    fun createProduct(product: Product): ProductEntity
    fun findProductById(id: Int): ProductEntity?
    fun updateProduct(id: Int, product: Product): ProductEntity?
    fun deleteProduct(id: Int): ProductEntity?
}