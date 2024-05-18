package br.group.twenty.challenge.application.adapters.product

import br.group.twenty.challenge.application.port.input.DeleteProductInputPort
import br.group.twenty.challenge.domain.models.Product

class DeleteProductAdapter(private val service: DeleteProductInputPort) : DeleteProduct {
    override fun deleteProduct(id: Int): Product? {
        return service.deleteProduct(id)
    }
}