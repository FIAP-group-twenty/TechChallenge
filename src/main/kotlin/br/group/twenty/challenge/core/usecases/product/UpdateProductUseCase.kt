package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class UpdateProductUseCase(
    private val gateway: ProductGateway,
    private val getProductByIdUseCase: GetProductByIdUseCase
) {
    fun execute(id: Int, product: Product): ProductEntity {
        getProductByIdUseCase.execute(id).let { oldProduct ->
            return gateway.updateProduct(oldProduct, product)
        }
    }
}