package br.group.twenty.challenge.infra.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_order_item")
data class OrderItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idOrderItem: Int? = null,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order", nullable = false)
    var order: OrderEntity? = null,

    @Column(name = "id_product", nullable = false)
    val idProduct: Int,

    @Column(nullable = false)
    val quantity: Int
)