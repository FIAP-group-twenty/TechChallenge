package br.group.twenty.challenge.core.entities.order

import br.group.twenty.challenge.core.entities.product.OrderProduct
import com.mercadopago.resources.payment.Payment
import java.math.BigDecimal

data class CreateOrder(
    val idCustomer: Int? = null,
    var totalValue: BigDecimal = BigDecimal.ZERO,
    val products: List<OrderProduct>,
    var payment: Payment?
) {
    fun calculateTotalValue(): BigDecimal {
        totalValue = products.fold(BigDecimal.ZERO) { acc, product ->
            acc + (product.price.multiply(product.quantity.toBigDecimal()))
        }
        return totalValue
    }

    fun associatePayment(payment: Payment?) {
        this.payment = payment
    }
}