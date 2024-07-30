package br.group.twenty.challenge.infrastructure.api.client

import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

interface IMercadoPagoPaymentDataSource {
    fun createPayment(amount: BigDecimal): Payment?
    fun getPayment(paymentId: Int): Payment
}