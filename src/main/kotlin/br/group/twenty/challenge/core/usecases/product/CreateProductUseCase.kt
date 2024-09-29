package br.group.twenty.challenge.core.usecases.product

import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.core.gateways.IProductGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity

class CreateProductUseCase(private val gateway: IProductGateway) {
     fun execute(product: Product): Product {
        return gateway.createProduct(product)
    }
}