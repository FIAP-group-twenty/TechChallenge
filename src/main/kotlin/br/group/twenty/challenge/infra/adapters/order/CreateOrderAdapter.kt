package br.group.twenty.challenge.infra.adapters.order

import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.infra.models.OrderEntity
import br.group.twenty.challenge.infra.repositories.OrderJpaRepository
import org.springframework.stereotype.Repository

class CreateOrderAdapter(
    private val repository: OrderJpaRepository
) : CreateOrderOutputPort {

    override fun createOrder(createOrderModel: CreateOrderModel): OrderEntity {
        return repository.save(
            OrderEntity(
                orderValue = createOrderModel.orderValue,
                idCustomer = createOrderModel.idCustomer,
                status = createOrderModel.status
            )
        )
    }
}