package br.group.twenty.challenge.core.gateways

import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

interface IPaymentPartnerGateway {
    fun getPayment(paymentId: Int): Payment
    fun createPayment(amount: BigDecimal): Payment?
}