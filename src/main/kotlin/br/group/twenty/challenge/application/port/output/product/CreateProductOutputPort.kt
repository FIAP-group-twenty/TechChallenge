package br.group.twenty.challenge.application.port.output.product

import br.group.twenty.challenge.domain.models.product.Product
import br.group.twenty.challenge.infra.models.ProductEntity

interface CreateProductOutputPort {
    fun createProduct(product: Product): ProductEntity
}