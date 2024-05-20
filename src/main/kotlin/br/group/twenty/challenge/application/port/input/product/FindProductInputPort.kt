package br.group.twenty.challenge.application.port.input.product

import br.group.twenty.challenge.domain.models.product.Product

interface FindProductInputPort {
    fun findProductById(id: Int): Product
    fun findProductByCategory(category: String): List<Product>
}