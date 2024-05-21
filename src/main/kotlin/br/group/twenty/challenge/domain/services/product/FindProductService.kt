package br.group.twenty.challenge.domain.services.product

import br.group.twenty.challenge.application.port.input.product.FindProductInputPort
import br.group.twenty.challenge.application.port.output.product.FindProductOutputPort
import br.group.twenty.challenge.domain.base.ResourceNotFoundException
import br.group.twenty.challenge.domain.models.mapper.ProductMapper
import br.group.twenty.challenge.domain.models.mapper.ProductMapper.toProducts
import br.group.twenty.challenge.domain.models.product.Product

class FindProductService(
    private val repository: FindProductOutputPort
) : FindProductInputPort {

    override fun findProductById(id: Int): Product {
        try {
            repository.findProductById(id)?.apply {
                return ProductMapper.toDTO(this)
            }
            throw ResourceNotFoundException("Product not found for Id: $id")

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }

    override fun findProductByCategory(category: String): List<Product> {
        try {
            repository.findProductByCategory(category).apply {
                if (this.firstOrNull() == null) {
                    throw ResourceNotFoundException("Product not found for category: $category")
                } else {
                    return this.toProducts()
                }
            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}