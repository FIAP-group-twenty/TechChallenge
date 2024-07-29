package br.group.twenty.challenge.infrastructure.gateways.payment

import br.group.twenty.challenge.core.entities.mapper.PaymentMapper.toEntity
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.IPaymentDataSource
import org.springframework.stereotype.Repository

@Repository
class PaymentGateway(
    private val paymentDataSource: IPaymentDataSource
) : IPaymentGateway {

    override fun updatePayment(oldPayment: PaymentEntity, status: String): PaymentEntity? {
        try {
            val paymentUpdate = oldPayment.validateStatus(status).toEntity(status)
            return paymentDataSource.save(paymentUpdate)
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to update payment with ID: ${oldPayment.idPay}", ex)
        }
    }

    override fun findPayment(mercadoPagoId: Int): PaymentEntity {
        try {
            paymentDataSource.findByMercadoPagoId(mercadoPagoId)?.let{ pay ->
                return pay
            }
            throw ResourceNotFoundException("Payment not found")
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find payment $mercadoPagoId.", ex)
        }
    }
}