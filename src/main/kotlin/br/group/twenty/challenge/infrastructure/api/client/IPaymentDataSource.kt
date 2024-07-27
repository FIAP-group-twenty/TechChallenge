package br.group.twenty.challenge.infrastructure.api.client

import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

interface IPaymentDataSource {
    fun createPayment(amount: BigDecimal): Payment?
    fun getPaymentStatus(paymentId: Int): Payment
}