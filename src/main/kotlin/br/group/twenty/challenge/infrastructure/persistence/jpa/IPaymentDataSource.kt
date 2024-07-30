package br.group.twenty.challenge.infrastructure.persistence.jpa

import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IPaymentDataSource : JpaRepository<PaymentEntity, Int> {
    fun findByMercadoPagoId(id: Int): PaymentEntity?
}
