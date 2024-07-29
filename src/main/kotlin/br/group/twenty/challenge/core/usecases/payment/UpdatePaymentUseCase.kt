package br.group.twenty.challenge.core.usecases.payment

import br.group.twenty.challenge.core.gateways.IMercadoPagoPaymentGateway
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity

class UpdatePaymentUseCase(
    private val mercadoPagoGateway: IMercadoPagoPaymentGateway,
    private val paymentGateway: IPaymentGateway,
) {
    fun execute(mercadoPagoId: Int): PaymentEntity? {
        try {
            val paymentMP = mercadoPagoGateway.getPayment(mercadoPagoId)
            val payment = paymentGateway.findPayment(mercadoPagoId)

            return paymentGateway.updatePayment(payment, paymentMP.status)
        } catch (ex: Exception) {
            throw ResourceInternalServerException(exception = ex)
        }
    }
}