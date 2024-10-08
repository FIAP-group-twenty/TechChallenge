package br.group.twenty.challenge.core.usecases.payment

import br.group.twenty.challenge.core.gateways.IPaymentPartnerGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

class CreatePaymentUseCase(private val gateway: IPaymentPartnerGateway) {
    fun execute(amount: BigDecimal): Payment {
        gateway.createPayment(amount)?.let { paymentOrder ->
            return paymentOrder
        }

        throw ResourceInternalServerException()
    }
}