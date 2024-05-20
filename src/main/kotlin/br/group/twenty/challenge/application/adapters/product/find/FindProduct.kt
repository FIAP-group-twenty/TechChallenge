package br.group.twenty.challenge.application.adapters.product.find

import br.group.twenty.challenge.domain.models.product.Product

interface FindProduct {
    fun findProductById(id: Int): Product?
    fun findProductByCategory(category: String): Product
}