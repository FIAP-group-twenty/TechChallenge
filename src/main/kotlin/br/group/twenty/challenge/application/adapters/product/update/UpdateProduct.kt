package br.group.twenty.challenge.application.adapters.product.update

import br.group.twenty.challenge.domain.models.product.Product

interface UpdateProduct {
    fun updateProduct(id: Int, product: Product): Product?
}