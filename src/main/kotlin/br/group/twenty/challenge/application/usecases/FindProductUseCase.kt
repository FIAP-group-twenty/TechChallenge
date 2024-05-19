package br.group.twenty.challenge.application.usecases

import br.group.twenty.challenge.domain.models.product.Product

interface FindProductUseCase {
    fun findProductById(id: Int): Product?
}