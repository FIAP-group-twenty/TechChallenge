package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.domain.models.product.Product

interface CreateProduct {
    fun createProduct(product: Product): Product?
}