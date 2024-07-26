package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class GetProductByIdUseCase(private val gateway: ProductGateway) {
    fun execute(id: Int): ProductEntity {
        return gateway.findProductById(id)
    }
}