package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.domain.models.Product

interface UpdateProduct {
    fun updateProduct(id: Int, product: Product): Product?
}