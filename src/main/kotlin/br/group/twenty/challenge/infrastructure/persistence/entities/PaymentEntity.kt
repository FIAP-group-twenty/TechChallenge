package br.group.twenty.challenge.infrastructure.persistence.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.persistence.FetchType.EAGER
import jakarta.persistence.GenerationType.IDENTITY
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_payment")
data class PaymentEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var idPay: Int? = null,

    @JsonIgnore
    @OneToOne(fetch = EAGER)
    @JoinColumn(name = "id_order", nullable = false)
    var order: OrderEntity? = null,

    val qrCode: String? = null,

    val status: String? = null,

    val payValue: BigDecimal? = null,

    val creationPay: LocalDateTime? = null,

    val lastUpdatePay: LocalDateTime? = null,
)