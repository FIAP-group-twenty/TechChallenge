package br.group.twenty.challenge.infra.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_order_item")
data class OrderItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idOrderItem: Int? = null,

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    val order: OrderEntity? = null,

    @Column(name = "id_product", nullable = false)
    val idProduct: Int,

    @Column(nullable = false)
    val quantity: Int
)