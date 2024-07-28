package br.group.twenty.challenge.api.configs

import br.group.twenty.challenge.core.usecases.customer.CreateCustomerUseCase
import br.group.twenty.challenge.core.usecases.customer.GetCustomerUseCase
import br.group.twenty.challenge.core.usecases.order.CreateOrderUseCase
import br.group.twenty.challenge.core.usecases.order.GetListOfOrdersUseCase
import br.group.twenty.challenge.core.usecases.order.UpdateOrderUseCase
import br.group.twenty.challenge.core.usecases.payment.CreatePaymentUseCase
import br.group.twenty.challenge.core.usecases.payment.GetPaymentStatusUseCase
import br.group.twenty.challenge.core.usecases.product.*
import br.group.twenty.challenge.infrastructure.api.client.IPaymentDataSource
import br.group.twenty.challenge.infrastructure.api.client.PaymentDataSource
import br.group.twenty.challenge.infrastructure.gateways.customer.CustomerGateway
import br.group.twenty.challenge.infrastructure.gateways.order.OrderGateway
import br.group.twenty.challenge.infrastructure.gateways.payment.PaymentGateway
import br.group.twenty.challenge.infrastructure.gateways.product.ProductGateway
import br.group.twenty.challenge.infrastructure.persistence.jpa.ICustomerDataSource
import br.group.twenty.challenge.infrastructure.persistence.jpa.IOrderDataSource
import br.group.twenty.challenge.infrastructure.persistence.jpa.IProductDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration(
    val orderDataSource: IOrderDataSource,
    val customerDataSource: ICustomerDataSource,
    val productDataSource: IProductDataSource
) {

    @Bean
    fun customerGateway(): CustomerGateway {
        return CustomerGateway(customerDataSource)
    }

    @Bean
    fun createCustomerUseCase(): CreateCustomerUseCase {
        return CreateCustomerUseCase(customerGateway())
    }

    @Bean
    fun getCustomerUseCase(): GetCustomerUseCase {
        return GetCustomerUseCase(customerGateway())
    }

    @Bean
    fun orderGateway(): OrderGateway {
        return OrderGateway(orderDataSource)
    }

    @Bean
    fun createOrderUseCase(): CreateOrderUseCase {
        return CreateOrderUseCase(orderGateway(), productGateway(), paymentGateway())
    }

    @Bean
    fun findListOfOrdersUseCase(): GetListOfOrdersUseCase {
        return GetListOfOrdersUseCase(orderGateway())
    }

    @Bean
    fun updateOrderUseCase(): UpdateOrderUseCase{
        return UpdateOrderUseCase(orderGateway())
    }

    @Bean
    fun productGateway(): ProductGateway {
        return ProductGateway(productDataSource)
    }

    @Bean
    fun createProductUseCase(): CreateProductUseCase {
        return CreateProductUseCase(productGateway())
    }

    @Bean
    fun deleteProductUseCase(): DeleteProductUseCase {
        return DeleteProductUseCase(productGateway())
    }

    @Bean
    fun getProductByCategoryUseCase(): GetProductByCategoryUseCase {
        return GetProductByCategoryUseCase(productGateway())
    }

    @Bean
    fun getProductByIdUseCase(): GetProductByIdUseCase {
        return GetProductByIdUseCase(productGateway())
    }

    @Bean
    fun updateProductUseCase(): UpdateProductUseCase {
        return UpdateProductUseCase(productGateway())
    }

    @Bean
    fun paymentGateway(): PaymentGateway {
        return PaymentGateway(PaymentDataSource())
    }

    @Bean
    fun createPaymentUseCase(): CreatePaymentUseCase {
        return CreatePaymentUseCase(paymentGateway())
    }

    @Bean
    fun getPaymentStatusUseCase(): GetPaymentStatusUseCase {
        return GetPaymentStatusUseCase(paymentGateway(), orderGateway())
    }
}