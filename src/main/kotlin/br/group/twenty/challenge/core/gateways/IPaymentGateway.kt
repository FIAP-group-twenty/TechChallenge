package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.core.entities.payment.Payment

interface IPaymentGateway {
    fun updatePayment(oldPayment: Payment, status: String): Payment?
    fun findPayment(partnerId: Int): Payment
}