package br.group.twenty.challenge.application.adapters.product.find

import br.group.twenty.challenge.application.port.input.product.FindProductInputPort
import br.group.twenty.challenge.domain.models.product.Product

class FindProductAdapter(private val service: FindProductInputPort) : FindProduct {

    override fun findProductById(id: Int): Product {
        return service.findProductById(id)
    }

    override fun findProductByCategory(category: String): Product {
        return service.findProductByCategory(category)
    }
}