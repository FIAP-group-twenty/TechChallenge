package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class GetProductByCategoryUseCase(private val gateway: ProductGateway) {
    fun execute(category: String): List<Product> {
        return gateway.findProductByCategory(category)
    }
}