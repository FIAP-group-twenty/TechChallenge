package br.group.twenty.challenge.core.entities.order

import br.group.twenty.challenge.core.entities.product.ProductModel

data class CreateOrderModel(
    val idCustomer: Int? = null,
    val productList: List<ProductModel>
)