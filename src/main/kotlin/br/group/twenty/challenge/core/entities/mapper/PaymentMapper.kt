package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toEntity
import br.group.twenty.challenge.core.entities.mapper.PaymentMapper.toDto
import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.entities.payment.PaymentStatus
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import java.math.BigDecimal
import java.time.LocalDateTime

object PaymentMapper {

    fun Payment.toEntity(newStatus: String): PaymentEntity {
        return PaymentEntity(
            idPay = idPay,
            mercadoPagoId = mercadoPagoId,
            order = order?.toEntity(),
            qrCode = qrCode,
            status = newStatus,
            payValue = payValue,
            creationPay = creationOrder,
            lastUpdatePay = LocalDateTime.now()
        )
    }

    fun PaymentEntity.toDto(): Payment {
        return Payment(
            idPay = idPay,
            mercadoPagoId = mercadoPagoId,
            order = order?.let { myOrder ->
                OrderMapper.toDTO(myOrder)
            },
            qrCode = qrCode,
            status = status ?: PaymentStatus.PENDING.name,
            payValue = payValue ?: BigDecimal.ZERO,
            creationOrder = creationPay,
            lastUpdateOrder = lastUpdatePay
        )
    }
}