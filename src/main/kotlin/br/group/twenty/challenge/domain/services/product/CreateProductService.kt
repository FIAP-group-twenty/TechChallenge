package br.group.twenty.challenge.domain.services.product

import br.group.twenty.challenge.application.port.input.product.CreateProductInputPort
import br.group.twenty.challenge.application.port.output.product.CreateProductOutputPort
import br.group.twenty.challenge.domain.models.mapper.ProductMapper
import br.group.twenty.challenge.domain.models.product.Product

class CreateProductService(
    private val repository: CreateProductOutputPort
) : CreateProductInputPort {

    override fun createProduct(productRequest: Product): Product {
        try {
            repository.createProduct(productRequest).apply {
                return ProductMapper.toDTO(this)
            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}