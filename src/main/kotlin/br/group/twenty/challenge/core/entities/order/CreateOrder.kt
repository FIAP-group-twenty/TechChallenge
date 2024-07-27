package br.group.twenty.challenge.core.entities.order

import br.group.twenty.challenge.core.entities.product.OrderProduct
import java.math.BigDecimal

data class CreateOrder(
    val idCustomer: Int? = null,
    var orderValue: BigDecimal = BigDecimal.ZERO,
    val products: List<OrderProduct>
)