package br.group.twenty.challenge.infrastructure.persistence.jpa

import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IOrderDataSource: JpaRepository<OrderEntity, Int>{

}