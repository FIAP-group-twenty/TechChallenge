package br.group.twenty.challenge.infrastructure.persistence.entities

import br.group.twenty.challenge.core.entities.order.OrderStatus
import br.group.twenty.challenge.core.entities.order.OrderStatus.CANCELED
import br.group.twenty.challenge.core.entities.order.OrderStatus.FINISHED
import br.group.twenty.challenge.core.entities.order.OrderStatus.IN_PROGRESS
import br.group.twenty.challenge.core.entities.order.OrderStatus.PENDING
import br.group.twenty.challenge.core.entities.order.OrderStatus.STARTED
import br.group.twenty.challenge.core.exceptions.ResourceBusinessException
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.ToString
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_order")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idOrder: Int? = null,
    val orderValue: BigDecimal,

    @NotNull
    val idCustomer: Int? = null,

    val creationOrder: LocalDateTime? = LocalDateTime.now(),
    var lastUpdateOrder: LocalDateTime? = LocalDateTime.now(),
    var status: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    @ToString.Exclude
    val orderItens: List<OrderItemEntity>,

    @OneToOne(mappedBy = "order", cascade = [CascadeType.ALL])
    var payment: PaymentEntity
) {
    fun formatter(order: OrderEntity): OrderEntity {
        order.orderItens.forEach {
            it.order = order
        }

        order.payment.order = order

        return order
    }

    fun validateStatus(status: String): OrderEntity {
        return when {
            this.status in listOf(FINISHED.name, CANCELED.name) ->
                throw ResourceBusinessException("Order status cannot be updated because it is in final status")

            this.status == status -> throw ResourceBusinessException("Order status is already $status")
            this.status == PENDING.name && status != STARTED.name ->
                throw ResourceBusinessException("Order status cannot be updated to $status")

            this.status == STARTED.name && status !in listOf(CANCELED.name, IN_PROGRESS.name) ->
                throw ResourceBusinessException("Order status cannot be updated to $status")

            this.status == IN_PROGRESS.name && status !in listOf(CANCELED.name, FINISHED.name) ->
                throw ResourceBusinessException("Order status cannot be updated to $status")

            else -> this
        }
    }
}

