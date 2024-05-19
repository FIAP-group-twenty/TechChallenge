package br.group.twenty.challenge.application.port.input

import br.group.twenty.challenge.domain.models.product.Product

interface UpdateProductInputPort {
    fun updateProduct(id: Int, product: Product): Product?
}