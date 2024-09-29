package br.group.twenty.challenge.infrastructure.gateways.order

import br.group.twenty.challenge.core.entities.mapper.OrderMapper.formatterOrderList
import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toDTO
import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toEntity
import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.utils.CREATE_ORDER_ERROR
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.jpa.IOrderDataSource
import org.springframework.stereotype.Repository

@Repository
class OrderGateway(
    private val orderDataSource: IOrderDataSource
) : IOrderGateway {

    override fun createOrder(createOrder: CreateOrder): Order {
        try {
            val order = toEntity(createOrder)
            val result = orderDataSource.save(order.formatter(order))
            return toDTO(result)
        } catch (ex: Exception) {
            throw ResourceInternalServerException(CREATE_ORDER_ERROR, ex)
        }
    }

    override fun findListOfOrders(): List<Order> {
        try {
            val result = orderDataSource.findOrdersByStatusAndCreationTime()
            return formatterOrderList(result)
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Unable to list orders, please try again later.", ex)
        }
    }

    override fun updateOrderStatus(oldOrder: Order, order: UpdateOrder): Order {
        try {
            val orderUpdate = oldOrder.toEntity(order) //todo: depois implementar validador de status de volta
            val result = orderDataSource.save(orderUpdate)
            return toDTO(result)
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to update order with ID: ${oldOrder.idOrder}", ex)
        }
    }

    override fun findOrder(orderId: Int): Order {
        try {
            orderDataSource.findByIdOrder(orderId)?.let { order ->
                return toDTO(order)
            }
            throw ResourceNotFoundException("Order not found")
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find order $orderId.", ex)
        }
    }
}