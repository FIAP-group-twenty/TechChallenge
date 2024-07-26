package br.group.twenty.challenge.infrastructure.gateways.order

import br.group.twenty.challenge.core.entities.order.OrderStatus
import br.group.twenty.challenge.core.entities.payment.PaymentStatus
import br.group.twenty.challenge.core.entities.order.CreateOrderModel
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderItemEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.IOrderDataSource
import br.group.twenty.challenge.infrastructure.persistence.jpa.IProductDataSource
import com.mercadopago.MercadoPagoConfig
import com.mercadopago.client.payment.PaymentClient
import com.mercadopago.client.payment.PaymentCreateRequest
import com.mercadopago.client.payment.PaymentPayerRequest
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class OrderGateway(
    private val orderDataSource: IOrderDataSource,
    private val productDataSource: IProductDataSource
) : IOrderGateway {

    override fun createOrder(createOrderModel: CreateOrderModel): OrderEntity {
        try {
            var orderValue = BigDecimal.ZERO

            createOrderModel.productList.forEach {
                val price = productDataSource.findByIdProduct(it.id)?.price?.toBigDecimal()
                val quantity = it.quantity
                orderValue += price!!.multiply(quantity.toBigDecimal())
            }

            MercadoPagoConfig.setAccessToken("TEST-1405158007413614-072110-c1f6e5cfc6c88cb6c282e4eb4a378a31-745903552")
            val paymentClient = PaymentClient()
            val payment = paymentClient.create(
                PaymentCreateRequest.builder()
                    .transactionAmount(orderValue)
                    .payer(PaymentPayerRequest.builder().id("1182098345-12JIUzreYBylDG").build())
                    .paymentMethodId("pix")
                    .build()
            )

            val order = OrderEntity(
                orderValue = orderValue,
                idCustomer = createOrderModel.idCustomer,
                status = OrderStatus.PENDING.name,
                orderItens = createOrderModel.productList.map { productModel ->
                    OrderItemEntity(
                        idProduct = productModel.id,
                        quantity = productModel.quantity,
                    )
                },
                payment = PaymentEntity(
                    qrCode = payment.pointOfInteraction.transactionData.qrCode,
                    status = PaymentStatus.PENDING.name,
                    payValue = orderValue
                )
            )

            order.orderItens.forEach {
                it.order = order
            }

            order.payment.order = order

            return orderDataSource.save(
                order
            )

        } catch (ex: Exception) {
            throw ex
        }
    }

    override fun findListOfOrders(): List<OrderEntity> {
        try {
            return orderDataSource.findAll()
        } catch (ex: Exception) {
            throw ex
        }
    }
}