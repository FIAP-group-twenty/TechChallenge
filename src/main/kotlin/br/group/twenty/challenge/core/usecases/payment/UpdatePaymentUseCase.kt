package br.group.twenty.challenge.core.usecases.payment

import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toUpdateOrderRequest
import br.group.twenty.challenge.core.gateways.IMercadoPagoPaymentGateway
import br.group.twenty.challenge.core.gateways.IOrderGateway
import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity

class UpdatePaymentUseCase(
    private val mercadoPagoGateway: IMercadoPagoPaymentGateway,
    private val paymentGateway: IPaymentGateway,
    private val orderGateway: IOrderGateway,
) {
    fun execute(mercadoPagoId: Int): PaymentEntity? {
        try {
            val paymentMP = mercadoPagoGateway.getPayment(mercadoPagoId)
            val payment = paymentGateway.findPayment(mercadoPagoId)

            paymentGateway.updatePayment(payment, paymentMP.status)?.let {
                orderGateway.updateOrderStatus(it.order!!, toUpdateOrderRequest(it.status!!))
            }

            return payment

        } catch (ex: Exception) {
            throw ResourceInternalServerException(exception = ex)
        }
    }
}