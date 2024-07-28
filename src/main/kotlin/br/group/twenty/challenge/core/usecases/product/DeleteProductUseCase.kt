package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class DeleteProductUseCase(
    private val gateway: ProductGateway
) {
    fun execute(id: Int): ProductEntity {
        gateway.findProductById(id).let { product ->
            return gateway.deleteProduct(product)
        }
    }
}