package br.group.twenty.challenge.core.gateways

import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

interface IPaymentGateway {
    fun getPaymentStatus(paymentId: Int): Payment
    fun createPayment(amount: BigDecimal): Payment?
}