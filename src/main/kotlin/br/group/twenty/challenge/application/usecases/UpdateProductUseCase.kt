package br.group.twenty.challenge.application.usecases

import br.group.twenty.challenge.domain.models.product.Product

interface UpdateProductUseCase {
    fun updateProduct(id: Int, updatedProduct: Product): Product?
}