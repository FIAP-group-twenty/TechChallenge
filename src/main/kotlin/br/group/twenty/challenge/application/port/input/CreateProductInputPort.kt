package br.group.twenty.challenge.application.port.input

import br.group.twenty.challenge.domain.models.product.Product

interface CreateProductInputPort {
    fun createProduct(productRequest: Product): Product
}