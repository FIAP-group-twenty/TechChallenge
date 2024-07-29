package br.group.twenty.challenge.core.gateways

import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity

interface IPaymentGateway {
    fun updatePayment(oldPayment: PaymentEntity, status: String): PaymentEntity?
    fun findPayment(mercadoPagoId: Int): PaymentEntity
}