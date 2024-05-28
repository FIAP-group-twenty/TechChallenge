package br.group.twenty.challenge.infra.models

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_order")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idOrder: Int? = null,
    val orderValue: BigDecimal,

    @NotNull
    val idCustomer: Int? = null,

    val creationOrder: LocalDateTime? = LocalDateTime.now(),
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now(),
    val status: String,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val orderItens: List<OrderItemEntity>
)

