package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class DeleteProductUseCase(
    private val gateway: ProductGateway,
    private val getProductByIdUseCase: GetProductByIdUseCase
) {
    fun execute(id: Int): ProductEntity {
        return gateway.deleteProduct(getProductByIdUseCase.execute(id))
    }
}