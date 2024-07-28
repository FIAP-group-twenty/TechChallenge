package br.group.twenty.challenge.infrastructure.gateways.order

import br.group.twenty.challenge.core.gateways.IOrderGateway
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
            return orderDataSource.save(order.formatter(order))
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Unable to complete your order, please try again later.", ex)
        }
    }

    override fun findListOfOrders(): List<OrderEntity> {
        try {
            return orderDataSource.findAll()
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Unable to list orders, please try again later.", ex)
        }
    }

    override fun updateOrder(order: OrderEntity): OrderEntity {
        try {
            return orderDataSource.save(order.formatter(order))
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to update order ${order.idOrder}.", ex)
        }
    }

    override fun findOrder(orderId: Int): OrderEntity? {
        try {
            return orderDataSource.findByIdOrder(orderId)
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find order $orderId.", ex)
        }
    }
}