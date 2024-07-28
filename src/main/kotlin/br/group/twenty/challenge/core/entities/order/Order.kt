package br.group.twenty.challenge.core.entities.order

import br.group.twenty.challenge.infrastructure.persistence.entities.OrderItemEntity
import br.group.twenty.challenge.infrastructure.persistence.entities.PaymentEntity
import java.math.BigDecimal
import java.time.LocalDateTime

data class Order(
    val idOrder: Int? = null,
    val orderValue: BigDecimal,
    val idCustomer: Int? = null,
    val creationOrder: LocalDateTime? = LocalDateTime.now(),//talvez mudar tipo
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now(),//talvez mudar tipo
    val status: String,
    val orderItems: List<OrderItemEntity>,
    val payment: PaymentEntity
)