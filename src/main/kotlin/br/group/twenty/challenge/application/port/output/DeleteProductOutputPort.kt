package br.group.twenty.challenge.application.port.output

import br.group.twenty.challenge.infra.models.ProductEntity

interface DeleteProductOutputPort {
    fun deleteProduct(id: Int): ProductEntity?
}