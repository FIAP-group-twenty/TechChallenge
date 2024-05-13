package br.group.twenty.challenge.domain.services

import br.group.twenty.challenge.application.port.input.CreateProductInputPort
import br.group.twenty.challenge.application.port.output.CreateProductOutputPort
import br.group.twenty.challenge.domain.models.Product

class CreateProductService(
    private val repository: CreateProductOutputPort
) : CreateProductInputPort {

    override fun createProduct(productRequest: Product): Product {
        try {
            repository.createProduct(productRequest).apply {
                return Product(idProduct, name, category, price, description)
            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}