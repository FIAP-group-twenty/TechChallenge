package br.group.twenty.challenge.infra.repositories

import br.group.twenty.challenge.infra.models.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<ProductEntity, Int> {
    fun findByIdProduct(id: Int): ProductEntity?
    fun findByCategory(category: String?): List<ProductEntity>
}