package br.group.twenty.challenge.infrastructure.persistence.jpa

import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface IOrderDataSource : JpaRepository<OrderEntity, Int> {
    fun findByIdOrder(id: Int): OrderEntity?

    @Query(
        "SELECT o FROM OrderEntity o " +
        "WHERE o.status NOT IN ('PENDING', 'CANCELED') " +
        "ORDER BY " +
        "CASE " +
        "  WHEN o.status = 'READY' THEN 1 " +
        "  WHEN o.status = 'IN_PROGRESS' THEN 2 " +
        "  WHEN o.status = 'STARTED' THEN 3 " +
        "  ELSE 4 " +
        "END, " +
        "o.creationOrder DESC"
    )
    fun findOrdersByStatusAndCreationTime(): List<OrderEntity>
}
