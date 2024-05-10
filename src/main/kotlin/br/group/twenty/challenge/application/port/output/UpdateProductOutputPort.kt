package br.group.twenty.challenge.application.port.output

import br.group.twenty.challenge.domain.models.Product
import br.group.twenty.challenge.infra.models.ProductEntity

interface UpdateProductOutputPort {
    fun updateProduct(id: Int, product: Product): ProductEntity?
}