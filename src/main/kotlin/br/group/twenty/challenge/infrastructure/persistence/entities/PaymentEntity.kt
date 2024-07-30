package br.group.twenty.challenge.infrastructure.persistence.entities

import br.group.twenty.challenge.core.entities.payment.PaymentStatus.APPROVED
import br.group.twenty.challenge.core.entities.payment.PaymentStatus.DENIED
import br.group.twenty.challenge.core.exceptions.ResourceBusinessException
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
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
    @GeneratedValue(strategy = IDENTITY)
    var idPay: Int? = null,

    var mercadoPagoId: Int? = null,

    @JsonIgnore
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    @ToString.Exclude
    var order: OrderEntity? = null,

    val qrCode: String? = null,

    var status: String? = null,

    val payValue: BigDecimal? = null,

    val creationPay: LocalDateTime? = null,

    var lastUpdatePay: LocalDateTime? = null
){
    override fun toString(): String {
        return "PaymentEntity(idPay=$idPay, qrCode=$qrCode, status=$status, payValue=$payValue)"
    }

    fun validateStatus(status: String): PaymentEntity {
        return when {
            this.status in listOf(APPROVED.name, DENIED.name) ->
                throw ResourceBusinessException("Payment status cannot be updated because it is in final status")
            this.status == status -> throw ResourceBusinessException("Order status is already $status")
            else -> this
        }
    }
}