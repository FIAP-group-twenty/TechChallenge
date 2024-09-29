package br.group.twenty.challenge.core.usecases.payment

import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toUpdateOrderRequest
import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.core.gateways.IPaymentPartnerGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException

class UpdatePaymentUseCase(
    private val mercadoPagoGateway: IPaymentPartnerGateway,
    private val paymentGateway: IPaymentGateway,
    private val orderGateway: IOrderGateway,
) {
    fun execute(mercadoPagoId: Int): Payment {
        try {
            val paymentMP = mercadoPagoGateway.getPayment(mercadoPagoId)
            val payment = paymentGateway.findPayment(mercadoPagoId)

            paymentGateway.updatePayment(payment, paymentMP.status)?.let {
                orderGateway.updateOrderStatus(it.order!!, toUpdateOrderRequest(it.status))
            }

            return payment

        } catch (ex: Exception) {
            throw ResourceInternalServerException(exception = ex)
        }
    }
}