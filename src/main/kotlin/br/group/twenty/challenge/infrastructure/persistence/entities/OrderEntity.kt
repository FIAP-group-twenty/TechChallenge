package br.group.twenty.challenge.infrastructure.persistence.entities

import jakarta.persistence.*
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
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now(),
    val status: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val orderItens: List<OrderItemEntity>,

    @OneToOne(mappedBy = "order", cascade = [CascadeType.ALL])
    val payment: PaymentEntity
) {
    fun formatter(order: OrderEntity): OrderEntity {
        order.orderItens.forEach {
            it.order = order
        }

        order.payment.order = order

        return order
    }
}

