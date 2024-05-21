package br.group.twenty.challenge.application.usecases.product

import br.group.twenty.challenge.domain.models.product.Product

interface CreateProductUseCase {
    fun createProduct(productRequest: Product): Product
}