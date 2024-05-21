package br.group.twenty.challenge.application.adapters.product.create

import br.group.twenty.challenge.application.port.input.product.CreateProductInputPort
import br.group.twenty.challenge.domain.models.product.Product

class CreateProductAdapter(private val service: CreateProductInputPort) : CreateProduct {
    override fun createProduct(product: Product): Product {
        return service.createProduct(product)
    }
}