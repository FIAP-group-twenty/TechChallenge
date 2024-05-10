package br.group.twenty.challenge.infra.repositories

import br.group.twenty.challenge.infra.models.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<ProductEntity, Int> {
    fun findProductById(id: Int): ProductEntity?
}