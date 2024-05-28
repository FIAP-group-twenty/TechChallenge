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
        val orderValue = BigDecimal.ZERO
        createOrderModel.productList.forEach {
            orderValue.plus(
                findProductAdapter.findProductById(it.id)?.price?.toBigDecimal()?.times(it.quantity.toBigDecimal())
                    ?: BigDecimal.ZERO
            )
        }

        return repository.save(
            OrderEntity(
                orderValue = orderValue,
                idCustomer = createOrderModel.idCustomer,
                status = OrderStatus.STARTED.name,
                orderItens = createOrderModel.productList.map { productModel ->
                    OrderItemEntity(
                        idProduct = productModel.id,
                        quantity = productModel.quantity,
                        order = null
                    )
                }
            )
        )
    }
}