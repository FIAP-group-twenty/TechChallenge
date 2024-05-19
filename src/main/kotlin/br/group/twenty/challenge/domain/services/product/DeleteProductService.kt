package br.group.twenty.challenge.domain.services.product

import br.group.twenty.challenge.application.port.input.DeleteProductInputPort
import br.group.twenty.challenge.application.port.output.DeleteProductOutputPort
import br.group.twenty.challenge.application.port.output.FindProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product

class DeleteProductService(
    private val repository: DeleteProductOutputPort,
    private val findRepository: FindProductOutputPort
) : DeleteProductInputPort {

    override fun deleteProduct(id: Int): Product? {
        try {
            findRepository.findProductById(id)?.apply {
                repository.deleteProduct(id).apply {
                    return Product(this!!.idProduct, name, category, price, description)
                }
            }
            return null

        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}