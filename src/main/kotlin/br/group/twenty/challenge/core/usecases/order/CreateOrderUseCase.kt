package br.group.twenty.challenge.core.usecases.order

import br.group.twenty.challenge.core.entities.mapper.OrderMapper
import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.core.gateways.IProductGateway
import br.group.twenty.challenge.core.utils.CREATE_QRCODE_ERROR
import br.group.twenty.challenge.infrastructure.exceptions.ResourceBadRequestException
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import com.mercadopago.resources.payment.Payment
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import java.util.logging.Logger

class CreateOrderUseCase(
    private val orderGateway: IOrderGateway,
    private val productGateway: IProductGateway,
    private val paymentGateway: IPaymentGateway
) {
    fun execute(createOrder: CreateOrder): OrderEntity {
        val logger = LoggerFactory.getLogger(CreateOrderUseCase::class.java)
        try {
            logger.info("teste 1")
            val myOrder = orderGateway.createOrder(formatterOrder(createOrder))
            logger.info("teste 2")
            val payment = paymentGateway.createPayment(myOrder.orderValue)

//            if (payment == null) {
//                logger.info("teste 3")
//                throw ResourceBadRequestException(message = CREATE_QRCODE_ERROR)
//            } else {

            logger.info("teste 4")
            myOrder.status = OrderMapper.orderStatus(payment)
            logger.info("teste 5")
            myOrder.payment = OrderMapper.toPayment(myOrder, payment)
            logger.info("teste 6")
            val teste = myOrder.formatter(myOrder)
//            logger.info(teste.toString())
            return orderGateway.updateOrder(teste)
//            }
        } catch (ex: Exception) {
            logger.info("teste 7")
            logger.info(ex.message)
            throw ResourceInternalServerException("Unable to complete your order, please try again later. 2", ex)
        }
    }

    private fun formatterOrder(createOrder: CreateOrder, payment: Payment? = null): OrderEntity {
        try {
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

            createOrder.orderValue = orderValue
            return OrderMapper.toEntity(createOrder, payment)
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Unable to complete your order, please try again later 3", ex)
        }
    }
}