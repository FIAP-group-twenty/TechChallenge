package br.group.twenty.challenge.infrastructure.gateways.payment

import br.group.twenty.challenge.core.gateways.IPaymentGateway
import br.group.twenty.challenge.infrastructure.api.client.IPaymentDataSource
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import com.mercadopago.MercadoPagoConfig
import com.mercadopago.client.payment.PaymentClient
import com.mercadopago.client.payment.PaymentCreateRequest
import com.mercadopago.client.payment.PaymentPayerRequest
import com.mercadopago.resources.payment.Payment
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class PaymentGateway(
    private val dataSource: IPaymentDataSource
) : IPaymentGateway {

    override fun getPaymentStatus(paymentId: Int): Payment {
        try {
            return dataSource.getPaymentStatus(paymentId)
        } catch (ex: Exception) {
            throw ResourceInternalServerException(exception = ex)
        }

    }

    override fun createPayment(amount: BigDecimal): Payment? {
        return try {
            dataSource.createPayment(amount)
        } catch (ex: Exception) {
            null
        }
    }
}