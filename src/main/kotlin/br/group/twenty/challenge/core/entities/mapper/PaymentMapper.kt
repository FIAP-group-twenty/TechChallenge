package br.group.twenty.challenge.core.entities.mapper

import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import java.time.LocalDateTime

object PaymentMapper {

    fun PaymentEntity.toEntity(newStatus: String): PaymentEntity {
        return this.apply {
            status = newStatus
            lastUpdatePay = LocalDateTime.now()
        }
    }

}