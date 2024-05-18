package br.group.twenty.challenge.api.configs

import br.group.twenty.challenge.application.adapters.order.CreateOrder
import br.group.twenty.challenge.application.adapters.order.CreateOrderAdapter
import br.group.twenty.challenge.application.port.input.order.CreateOrderInputPort
import br.group.twenty.challenge.application.port.output.CreateProductOutputPort
import br.group.twenty.challenge.application.port.output.order.CreateOrderOutputPort
import br.group.twenty.challenge.application.services.CustomerService
import br.group.twenty.challenge.application.services.ProductService
import br.group.twenty.challenge.application.usecases.CreateCustomerUseCase
import br.group.twenty.challenge.application.usecases.CreateProductUseCase
import br.group.twenty.challenge.domain.ports.CustomerPort
import br.group.twenty.challenge.domain.ports.ProductPort
import br.group.twenty.challenge.domain.services.order.CreateOrderService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration(val orderRepository: CreateOrderOutputPort) {

    @Bean
    fun createCustomer(repository: CustomerPort): CreateCustomerUseCase {
        return CustomerService(repository)
    }

    @Bean
    fun createOrderInputPort(): CreateOrderInputPort {
        return CreateOrderService(orderRepository)
    }

    @Bean
    fun createAdapterOrder(): CreateOrder{
        return CreateOrderAdapter(createOrderInputPort())
    }

    @Bean
    fun createProduct(repository: ProductPort): CreateProductUseCase {
        return ProductService(repository)
    }
}