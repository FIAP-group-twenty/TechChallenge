package br.group.twenty.challenge.domain.models.order

import br.group.twenty.challenge.domain.models.product.ProductModel
import java.math.BigDecimal

data class CreateOrderModel(
    val idCustomer: Int? = null,
    val productList: List<ProductModel>
)