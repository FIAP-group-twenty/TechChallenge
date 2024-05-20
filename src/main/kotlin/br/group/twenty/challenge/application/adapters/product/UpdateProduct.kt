package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.domain.models.product.Product

interface UpdateProduct {
    fun updateProduct(id: Int, product: Product): Product?
}