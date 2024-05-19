package br.group.twenty.challenge.application.port.input.product

import br.group.twenty.challenge.domain.models.product.Product

interface DeleteProductInputPort {
    fun deleteProduct(id: Int): Product?
}