package br.group.twenty.challenge.core.usecases.payment

import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IPaymentPartnerGateway
import br.group.twenty.challenge.core.utils.FIND_PAYMENT_INFORMATION_ERROR
import br.group.twenty.challenge.infrastructure.api.entities.PaymentInformation
import br.group.twenty.challenge.infrastructure.exceptions.ResourceBadRequestException
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException

class GetPaymentStatusUseCase(
    private val paymentGateway: IPaymentPartnerGateway,
    private val orderGateway: IOrderGateway
) {
    fun execute(orderId: Int): PaymentInformation {
        try {
            val order = orderGateway.findOrder(orderId)
            order?.payment?.mercadoPagoId?.let { paymentId ->
                val payment = paymentGateway.getPayment(paymentId)
                return PaymentInformation(order = order, payment = payment)
            } ?: throw ResourceBadRequestException(FIND_PAYMENT_INFORMATION_ERROR)
        } catch (ex: Exception) {
            throw ResourceInternalServerException(exception = ex)
        }
    }
}