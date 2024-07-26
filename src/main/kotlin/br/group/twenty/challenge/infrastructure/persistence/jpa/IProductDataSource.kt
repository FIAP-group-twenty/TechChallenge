package br.group.twenty.challenge.infrastructure.persistence.jpa

import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IProductDataSource : JpaRepository<ProductEntity, Int> {
    fun findByIdProduct(id: Int): ProductEntity?
    fun findByCategory(category: String?): List<ProductEntity>
}