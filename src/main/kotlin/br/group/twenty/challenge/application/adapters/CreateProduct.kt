package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.domain.models.Product

interface CreateProduct {
    fun createProduct(product: Product): Product?
}