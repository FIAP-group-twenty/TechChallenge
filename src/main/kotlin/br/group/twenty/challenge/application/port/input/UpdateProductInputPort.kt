package br.group.twenty.challenge.application.port.input

import br.group.twenty.challenge.domain.models.Product
import br.group.twenty.challenge.infra.models.ProductEntity

interface UpdateProductInputPort {
    fun updateProduct(id: Int, product: Product): Product?
}