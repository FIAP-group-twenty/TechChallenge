package br.group.twenty.challenge.infra.adapters.order

import br.group.twenty.challenge.application.enums.OrderStatus
import br.group.twenty.challenge.application.enums.PaymentStatus
import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.infra.adapters.product.FindProductAdapter
import br.group.twenty.challenge.infra.models.OrderEntity
import br.group.twenty.challenge.infra.models.OrderItemEntity
import br.group.twenty.challenge.infra.models.PaymentEntity
import br.group.twenty.challenge.infra.repositories.OrderJpaRepository
import com.mercadopago.MercadoPagoConfig
import com.mercadopago.client.payment.PaymentClient
import com.mercadopago.client.payment.PaymentCreateRequest
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class CreateOrderAdapter(
    private val repository: OrderJpaRepository,
    private val findProductAdapter: FindProductAdapter
) : CreateOrderOutputPort {

    override fun createOrder(createOrderModel: CreateOrderModel): OrderEntity {
        var orderValue = BigDecimal.ZERO

        createOrderModel.productList.forEach {
            val price =  findProductAdapter.findProductById(it.id)?.price?.toBigDecimal()
            val quantity = it.quantity
            orderValue += price!!.multiply(quantity.toBigDecimal())
        }

        MercadoPagoConfig.setAccessToken("TEST-1405158007413614-072110-c1f6e5cfc6c88cb6c282e4eb4a378a31-745903552")
        val paymentClient = PaymentClient()
        val payment = paymentClient.create(PaymentCreateRequest.builder()
            .transactionAmount(orderValue)
            .paymentMethodId("pix")
            .build())

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

        return repository.save(
            order
        )
    }
}