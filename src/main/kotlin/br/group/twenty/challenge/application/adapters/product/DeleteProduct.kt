package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.domain.models.Product

interface DeleteProduct {
    fun deleteProduct(id: Int): Product?
}