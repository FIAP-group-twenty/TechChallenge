package br.group.twenty.challenge.application.usecases

import br.group.twenty.challenge.domain.models.Product

interface DeleteProductUseCase {
    fun deleteProduct(id: Int): Product?
}