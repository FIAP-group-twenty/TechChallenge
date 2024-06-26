package br.group.twenty.challenge.api.configs

import br.group.twenty.challenge.application.adapters.customer.CreateCustomer
import br.group.twenty.challenge.application.adapters.customer.CreateCustomerAdapter
import br.group.twenty.challenge.application.adapters.customer.FindCustomer
import br.group.twenty.challenge.application.adapters.customer.FindCustomerAdapter
import br.group.twenty.challenge.application.adapters.order.CreateOrder
import br.group.twenty.challenge.application.adapters.order.CreateOrderAdapter
import br.group.twenty.challenge.application.adapters.order.FindListOfOrders
import br.group.twenty.challenge.application.adapters.order.FindListOfOrdersAdapter
import br.group.twenty.challenge.application.adapters.product.create.CreateProduct
import br.group.twenty.challenge.application.adapters.product.create.CreateProductAdapter
import br.group.twenty.challenge.application.adapters.product.delete.DeleteProduct
import br.group.twenty.challenge.application.adapters.product.delete.DeleteProductAdapter
import br.group.twenty.challenge.application.adapters.product.find.FindProduct
import br.group.twenty.challenge.application.adapters.product.find.FindProductAdapter
import br.group.twenty.challenge.application.port.input.product.CreateProductInputPort
import br.group.twenty.challenge.application.port.input.product.DeleteProductInputPort
import br.group.twenty.challenge.application.port.input.product.FindProductInputPort
import br.group.twenty.challenge.application.port.input.customer.CreateCustomerInputPort
import br.group.twenty.challenge.application.port.input.customer.FindCustomerInputPort
import br.group.twenty.challenge.application.port.input.order.CreateOrderInputPort
import br.group.twenty.challenge.application.port.input.order.FindListOfOrdersInputPort
import br.group.twenty.challenge.application.port.output.product.CreateProductOutputPort
import br.group.twenty.challenge.application.port.output.product.DeleteProductOutputPort
import br.group.twenty.challenge.application.port.output.product.FindProductOutputPort
import br.group.twenty.challenge.application.port.output.customer.CreateCustomerOutputPort
import br.group.twenty.challenge.application.port.output.customer.FindCustomerOutputPort
import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.application.port.output.order.FindListOfOrdersOutputPort
import br.group.twenty.challenge.domain.services.customer.CreateCustomerService
import br.group.twenty.challenge.domain.services.customer.FindCustomerService
import br.group.twenty.challenge.domain.services.order.CreateOrderService
import br.group.twenty.challenge.domain.services.order.FindListOfOrdersService
import br.group.twenty.challenge.domain.services.product.CreateProductService
import br.group.twenty.challenge.domain.services.product.DeleteProductService
import br.group.twenty.challenge.domain.services.product.FindProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration(
    val orderRepository: CreateOrderOutputPort,
    val findListOfOrdersRepository: FindListOfOrdersOutputPort,
    val createCustomerRepository: CreateCustomerOutputPort,
    val findCustomerRepository: FindCustomerOutputPort,
    val createProductRepository: CreateProductOutputPort,
    val findProductRepository: FindProductOutputPort,
    val deleteProductRepository: DeleteProductOutputPort,
    val createOrderRepository: CreateOrderOutputPort
) {

    @Bean
    fun createPortCustomer(): CreateCustomerInputPort {
        return CreateCustomerService(createCustomerRepository, findCustomerRepository)
    }

    @Bean
    fun createAdapterCustomer(): CreateCustomer {
        return CreateCustomerAdapter(createPortCustomer())
    }

    @Bean
    fun findPortCustomer(): FindCustomerInputPort {
        return FindCustomerService(findCustomerRepository)
    }

    @Bean
    fun findAdapterCustomer(): FindCustomer {
        return FindCustomerAdapter(findPortCustomer())
    }



    @Bean
    fun findPortListOfOrders(): FindListOfOrdersInputPort {
        return FindListOfOrdersService(findListOfOrdersRepository)
    }

    @Bean
    fun findListOfOrders(): FindListOfOrders {
        return FindListOfOrdersAdapter(findPortListOfOrders())
    }



    @Bean
    fun createPortProduct(): CreateProductInputPort {
        return CreateProductService(createProductRepository)
    }

    @Bean
    fun createProduct(): CreateProduct {
        return CreateProductAdapter(createPortProduct())
    }

    @Bean
    fun findPortProduct(): FindProductInputPort {
        return FindProductService(findProductRepository)
    }

    @Bean
    fun findProduct(): FindProduct {
        return FindProductAdapter(findPortProduct())
    }

    @Bean
    fun deletePortProduct(): DeleteProductInputPort {
        return DeleteProductService(deleteProductRepository, findProductRepository)
    }

    @Bean
    fun deleteProduct(): DeleteProduct {
        return DeleteProductAdapter(deletePortProduct())
    }

    @Bean
    fun orderServicePort(): CreateOrderInputPort {
        return CreateOrderService(createOrderRepository)
    }

    @Bean
    fun orderService(): CreateOrder {
        return CreateOrderAdapter(orderServicePort())
    }
}