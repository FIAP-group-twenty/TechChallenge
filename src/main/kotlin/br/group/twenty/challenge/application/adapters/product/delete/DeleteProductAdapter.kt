package br.group.twenty.challenge.application.adapters.product.delete

import br.group.twenty.challenge.application.port.input.product.DeleteProductInputPort
import br.group.twenty.challenge.domain.models.product.Product

class DeleteProductAdapter(private val service: DeleteProductInputPort) : DeleteProduct {
    override fun deleteProduct(id: Int): Product? {
        return service.deleteProduct(id)
    }
}