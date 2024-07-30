package br.group.twenty.challenge.infrastructure.gateways.order

import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toEntity
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.utils.CREATE_ORDER_ERROR
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.IOrderDataSource
import org.springframework.stereotype.Repository

@Repository
class OrderGateway(
    private val orderDataSource: IOrderDataSource
) : IOrderGateway {

    override fun createOrder(order: OrderEntity): OrderEntity {
        try {
            return orderDataSource.save(order)
        } catch (ex: Exception) {
            throw ResourceInternalServerException(CREATE_ORDER_ERROR, ex)
        }
    }

    override fun findListOfOrders(): List<OrderEntity> {
        try {
            return orderDataSource.findOrdersByStatusAndCreationTime()
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Unable to list orders, please try again later.", ex)
        }
    }

    override fun updateOrderStatus(oldOrder: OrderEntity, order: UpdateOrder): OrderEntity {
        try {
            val orderUpdate = oldOrder.validateStatus(order.status).toEntity(order)
            return orderDataSource.save(orderUpdate)
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to update order with ID: ${oldOrder.idOrder}", ex)
        }
    }

    override fun findOrder(orderId: Int): OrderEntity {
        try {
            orderDataSource.findByIdOrder(orderId)?.let { order ->
                return order
            }
            throw ResourceNotFoundException("Order not found")
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find order $orderId.", ex)
        }
    }
}