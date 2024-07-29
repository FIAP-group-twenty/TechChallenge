package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.OrderStatus.CANCELED
import br.group.twenty.challenge.core.entities.order.OrderStatus.PENDING
import br.group.twenty.challenge.core.entities.order.OrderStatus.STARTED
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.core.entities.payment.PaymentStatus
import br.group.twenty.challenge.core.entities.payment.PaymentStatus.APPROVED
import br.group.twenty.challenge.core.entities.payment.PaymentStatus.DENIED
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderItemEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import com.mercadopago.resources.payment.Payment

object OrderMapper {

    fun toEntity(createOrder: CreateOrder, payment: Payment?): OrderEntity {
        val orderStatus: String
        val paymentStatus: String
        when (payment?.status) {
            "approved" -> {
                orderStatus = STARTED.name
                paymentStatus = APPROVED.name
            }

            "rejected" -> {
                orderStatus = CANCELED.name
                paymentStatus = DENIED.name
            }

            else -> {
                orderStatus = PENDING.name
                paymentStatus = PaymentStatus.PENDING.name
            }
        }

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
                mercadoPagoId = payment?.id?.toInt(),
                qrCode = payment?.pointOfInteraction?.transactionData?.qrCode,
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

    fun toUpdateOrderRequest(payStatus: String): UpdateOrder {
        val status = when (payStatus) {
            APPROVED.name -> STARTED.name
            DENIED.name -> CANCELED.name
            else -> PENDING.name
        }

        return UpdateOrder(status = status)
    }

}