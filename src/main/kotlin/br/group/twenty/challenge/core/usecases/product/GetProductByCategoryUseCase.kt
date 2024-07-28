package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class GetProductByCategoryUseCase(private val gateway: ProductGateway) {
    fun execute(category: String): List<ProductEntity> {
        return gateway.findProductByCategory(category)
    }
}