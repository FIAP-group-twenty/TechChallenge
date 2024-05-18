package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.application.port.input.UpdateProductInputPort
import br.group.twenty.challenge.domain.models.Product

class UpdateProductAdapter(private val service: UpdateProductInputPort) : UpdateProduct {
    override fun updateProduct(id: Int, product: Product): Product? {
        return service.updateProduct(id, product)
    }
}