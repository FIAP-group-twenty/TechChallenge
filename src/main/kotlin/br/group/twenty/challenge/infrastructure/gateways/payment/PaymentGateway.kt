package br.group.twenty.challenge.infrastructure.gateways.payment

import br.group.twenty.challenge.core.entities.mapper.PaymentMapper.toDto
import br.group.twenty.challenge.core.entities.mapper.PaymentMapper.toEntity
import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.jpa.IPaymentDataSource
import org.springframework.stereotype.Repository

@Repository
class PaymentGateway(
    private val paymentDataSource: IPaymentDataSource
) : IPaymentGateway {

    override fun updatePayment(oldPayment: Payment, status: String): Payment? {
        try {
            val paymentUpdate = oldPayment.toEntity(status) //todo: todo: depois voltar validador do status
            val result = paymentDataSource.save(paymentUpdate)
            return result.toDto()
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to update payment with ID: ${oldPayment.idPay}", ex)
        }
    }

    override fun findPayment(partnerId: Int): Payment {
        try {
            paymentDataSource.findByMercadoPagoId(partnerId)?.let { pay ->
                return pay.toDto()
            }
            throw ResourceNotFoundException("Payment not found")
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find payment $partnerId.", ex)
        }
    }
}