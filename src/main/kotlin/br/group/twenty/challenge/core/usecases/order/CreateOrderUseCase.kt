package br.group.twenty.challenge.core.usecases.order

import br.group.twenty.challenge.core.entities.mapper.OrderMapper
import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IMercadoPagoPaymentGateway
import br.group.twenty.challenge.core.gateways.IProductGateway
import br.group.twenty.challenge.core.utils.CREATE_ORDER_ERROR
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import java.math.BigDecimal

class CreateOrderUseCase(
    private val orderGateway: IOrderGateway,
    private val productGateway: IProductGateway,
    private val paymentGateway: IMercadoPagoPaymentGateway
) {
    fun execute(createOrder: CreateOrder): OrderEntity {
        try {
            createOrder.orderValue = getOrderValue(createOrder)

            val payment = paymentGateway.createPayment(createOrder.orderValue)
            val myOrder = OrderMapper.toEntity(createOrder, payment)

            return orderGateway.createOrder(myOrder.formatter(myOrder))

        } catch (ex: Exception) {
            throw ResourceInternalServerException(CREATE_ORDER_ERROR, ex)
        }
    }

    private fun getOrderValue(createOrder: CreateOrder): BigDecimal {
        var orderValue = BigDecimal.ZERO

        createOrder.products.forEach { orderProduct ->
            productGateway.findProductById(orderProduct.id).price?.let { productPrice ->
                val price = productPrice.toBigDecimal()
                val quantity = orderProduct.quantity
                val product = createOrder.products.find { it.id == orderProduct.id }
                product?.price = productPrice
                orderValue += price.multiply(quantity.toBigDecimal())
            }
        }
        return orderValue
    }
}