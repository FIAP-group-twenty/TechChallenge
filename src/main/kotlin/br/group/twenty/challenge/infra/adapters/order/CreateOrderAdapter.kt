package br.group.twenty.challenge.infra.adapters.order

import br.group.twenty.challenge.application.enums.OrderStatus
import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.domain.models.order.CreateOrderModel
import br.group.twenty.challenge.infra.adapters.product.FindProductAdapter
import br.group.twenty.challenge.infra.models.OrderEntity
import br.group.twenty.challenge.infra.models.OrderItemEntity
import br.group.twenty.challenge.infra.repositories.OrderJpaRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class CreateOrderAdapter(
    private val repository: OrderJpaRepository,
    private val findProductAdapter: FindProductAdapter
) : CreateOrderOutputPort {

    override fun createOrder(createOrderModel: CreateOrderModel): OrderEntity {
        var orderValue = BigDecimal.ZERO
        createOrderModel.productList.forEach {
            val price =  findProductAdapter.findProductById(it.id)?.price?.toBigDecimal()
            val quantity = it.quantity
            orderValue += price!!.multiply(quantity.toBigDecimal())
        }
        val order = OrderEntity(
            orderValue = orderValue,
            idCustomer = createOrderModel.idCustomer,
            status = OrderStatus.STARTED.name,
            orderItens = createOrderModel.productList.map { productModel ->
                OrderItemEntity(
                    idProduct = productModel.id,
                    quantity = productModel.quantity,
                )
            }
        )
        order.orderItens.forEach {
            it.order = order
        }
        return repository.save(
            order
        )
    }
}