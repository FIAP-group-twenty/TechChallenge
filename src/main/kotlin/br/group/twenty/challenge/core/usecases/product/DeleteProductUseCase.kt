package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway

class DeleteProductUseCase(
    private val gateway: ProductGateway
) {
    fun execute(id: Int): Product {
        gateway.findProductById(id).let { product ->
            return gateway.deleteProduct(product)
        }
    }
}