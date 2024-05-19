package br.group.twenty.challenge.domain.services.product

import br.group.twenty.challenge.application.port.input.FindProductInputPort
import br.group.twenty.challenge.application.port.output.FindProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product

class FindProductService(
    private val repository: FindProductOutputPort
) : FindProductInputPort {

    override fun findProductById(id: Int): Product? {
        try {
            repository.findProductById(id)?.apply {
                return Product(name = name, category = category, price = price, description = description, id = idProduct)
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}