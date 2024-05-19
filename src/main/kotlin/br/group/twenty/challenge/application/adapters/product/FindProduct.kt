package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.domain.models.product.Product

interface FindProduct {
    fun findProductById(id: Int): Product?
}