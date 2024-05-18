package br.group.twenty.challenge.infra.repositories

import br.group.twenty.challenge.infra.models.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository: JpaRepository<OrderEntity, Int>{

}