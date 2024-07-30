package br.group.twenty.challenge.infrastructure.persistence.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.ToString

@Entity
@Table(name = "tb_order_item")
data class OrderItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idOrderItem: Int? = null,

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    @ToString.Exclude
    var order: OrderEntity? = null,

    @Column(name = "id_product", nullable = false)
    val idProduct: Int,

    @Column(nullable = false)
    val quantity: Int
){
    override fun toString(): String {
        return "OrderItemEntity(idOrderItem=$idOrderItem, idProduct=$idProduct, quantity=$quantity)"
    }
}