package br.group.twenty.challenge.infrastructure.persistence.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import lombok.ToString
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_payment")
data class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idPay: Int? = null,

    @JsonIgnore
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    @ToString.Exclude
    var order: OrderEntity? = null,

    val qrCode: String? = null,

    val status: String? = null,

    val payValue: BigDecimal? = null,

    val creationPay: LocalDateTime? = null,

    val lastUpdatePay: LocalDateTime? = null
){
    override fun toString(): String {
        return "PaymentEntity(idPay=$idPay, qrCode=$qrCode, status=$status, payValue=$payValue)"
    }
}