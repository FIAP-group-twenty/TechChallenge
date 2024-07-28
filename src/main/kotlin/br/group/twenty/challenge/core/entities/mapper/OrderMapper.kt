package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.OrderStatus
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.core.entities.payment.PaymentStatus
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderItemEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

object OrderMapper {

    fun toEntity(createOrder: CreateOrder, payment: Payment?): OrderEntity {
        val orderStatus = orderStatus(payment)
        val paymentStatus = paymentStatus(payment)

        return OrderEntity(
            orderValue = createOrder.orderValue,
            idCustomer = createOrder.idCustomer,
            status = orderStatus,
            orderItens = createOrder.products.map { productModel ->
                OrderItemEntity(
                    idProduct = productModel.id,
                    quantity = productModel.quantity,
                )
            },
            payment = PaymentEntity(
                qrCode = payment?.pointOfInteraction?.transactionData?.qrCode ?: "8762487hhdsjbdakhjhjdabhjadbhbajdad",
                status = paymentStatus,
                payValue = createOrder.orderValue
            )
        )
    }

    fun OrderEntity.toEntity(dto: UpdateOrder): OrderEntity {
        return this.apply {
            status = dto.status
            lastUpdateOrder = dto.lastUpdateOrder
        }
    }

    fun status(payment: Payment, orderValue: BigDecimal): UpdateOrder {
        val orderStatus = orderStatus(payment)
        val paymentStatus = paymentStatus(payment)

        return UpdateOrder(
            status = orderStatus, payment = PaymentEntity(
                qrCode = payment.pointOfInteraction?.transactionData?.qrCode,
                status = paymentStatus,
                payValue = orderValue
            )
        )
    }

    fun toPayment(order: OrderEntity, payment: Payment?): PaymentEntity {
        val paymentStatus = paymentStatus(payment)
        return PaymentEntity(
            qrCode = payment?.pointOfInteraction?.transactionData?.qrCode ?: "juhadjbbjdhahad7824787y9247924",
            status = paymentStatus,
            payValue = order.orderValue
        )
    }

    private fun paymentStatus(payment: Payment?): String {
        return when (payment?.status) {
            "approved" -> PaymentStatus.APPROVED.name
            "rejected" -> PaymentStatus.DENIED.name
            else -> PaymentStatus.PENDING.name
        }
    }

    fun orderStatus(payment: Payment?): String {
        return when (payment?.status) {
            "approved" -> OrderStatus.STARTED.name
            "rejected" -> OrderStatus.CANCELED.name
            else -> OrderStatus.PENDING.name
        }
    }

}