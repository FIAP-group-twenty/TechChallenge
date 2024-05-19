package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.application.port.input.CreateProductInputPort
import br.group.twenty.challenge.domain.models.product.Product

class CreateProductAdapter(private val service: CreateProductInputPort) : CreateProduct {
    override fun createProduct(product: Product): Product {
        return service.createProduct(product)
    }
}