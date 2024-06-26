package br.group.twenty.challenge.application.adapters.product.update

import br.group.twenty.challenge.application.port.input.product.UpdateProductInputPort
import br.group.twenty.challenge.domain.models.product.Product

class UpdateProductAdapter(private val service: UpdateProductInputPort) : UpdateProduct {
    override fun updateProduct(id: Int, product: Product): Product? {
        return service.updateProduct(id, product)
    }
}