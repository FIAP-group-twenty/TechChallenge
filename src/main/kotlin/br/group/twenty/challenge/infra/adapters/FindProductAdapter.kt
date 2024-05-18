package br.group.twenty.challenge.infra.adapters

import br.group.twenty.challenge.application.port.output.FindProductOutputPort
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class FindProductAdapter(private val repository: ProductJpaRepository) : FindProductOutputPort {

    override fun findProductById(id: Int): ProductEntity? {
        return repository.findByIdProduct(id)
    }
}