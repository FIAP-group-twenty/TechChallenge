package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.order.CreateOrder
import br.group.twenty.challenge.core.entities.order.OrderStatus
import br.group.twenty.challenge.core.entities.order.UpdateOrder
import br.group.twenty.challenge.core.entities.payment.PaymentStatus
import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.OrderItemEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity
import com.mercadopago.resources.payment.Payment

object OrderMapper {

    fun toEntity(createOrder: CreateOrder, payment: Payment?): OrderEntity {
        val orderStatus: String
        val paymentStatus: String
        when (payment?.status) {
            "approved" -> {
                orderStatus = OrderStatus.STARTED.name
                paymentStatus = PaymentStatus.APPROVED.name
            }

            "rejected" -> {
                orderStatus = OrderStatus.CANCELED.name
                paymentStatus = PaymentStatus.DENIED.name
            }

            else -> {
                orderStatus = OrderStatus.PENDING.name
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

}