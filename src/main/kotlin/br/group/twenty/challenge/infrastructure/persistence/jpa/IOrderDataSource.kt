package br.group.twenty.challenge.infrastructure.persistence.jpa

import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IOrderDataSource : JpaRepository<OrderEntity, Int> {
    fun findByIdOrder(id: Int): OrderEntity?
}
