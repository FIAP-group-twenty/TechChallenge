package br.group.twenty.challenge.infra.models

import jakarta.persistence.*
import org.springframework.cglib.core.Local
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "tb_order")
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idOrder: Int? = null,
    val orderValue: BigDecimal,
    val idCustomer: Int? = null,
    val creationOrder: LocalDateTime? = LocalDateTime.now(),//talvez mudar tipo
    val lastUpdateOrder: LocalDateTime? = LocalDateTime.now(),//talvez mudar tipo
    val status: String
)