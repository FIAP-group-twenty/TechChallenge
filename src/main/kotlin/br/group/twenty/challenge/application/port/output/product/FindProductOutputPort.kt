package br.group.twenty.challenge.application.port.output.product

import br.group.twenty.challenge.infra.models.ProductEntity

interface FindProductOutputPort {
    fun findProductById(id: Int): ProductEntity?
    fun findProductByCategory(category: String):  List<ProductEntity>
}