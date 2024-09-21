package br.group.twenty.challenge.core.usecases.order

import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.Order
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IPaymentPartnerGateway
import br.group.twenty.challenge.core.gateways.IProductGateway
import br.group.twenty.challenge.core.utils.CREATE_ORDER_ERROR
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException

class CreateOrderUseCase(
    private val orderGateway: IOrderGateway,
    private val productGateway: IProductGateway,
    private val paymentGateway: IPaymentPartnerGateway
) {
    fun execute(createOrder: CreateOrder): Order {
        try {
            createOrder.products.forEach { orderProduct ->
                val product = productGateway.findProductById(orderProduct.id)
                orderProduct.price = product.price
            }
            createOrder.calculateTotalValue()

            val payment = paymentGateway.createPayment(createOrder.totalValue)
            createOrder.associatePayment(payment)

            return orderGateway.createOrder(createOrder)

        } catch (ex: Exception) {
            throw ResourceInternalServerException(CREATE_ORDER_ERROR, ex)
        }
    }
}