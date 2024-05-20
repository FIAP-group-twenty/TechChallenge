package br.group.twenty.challenge.infra.adapters.order

import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.application.port.output.order.FindListOfOrdersOutputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.infra.models.OrderEntity
import br.group.twenty.challenge.infra.repositories.OrderJpaRepository
import org.springframework.stereotype.Repository

@Repository
class FindListOfOrdersAdapter(
    private val repository: OrderJpaRepository
) : FindListOfOrdersOutputPort {

    override fun findListOfOrders(): List<OrderEntity> {
        return repository.findAll()
    }
}