package br.group.twenty.challenge.infrastructure.api.client

import br.group.twenty.challenge.infrastructure.exceptions.ResourceBadRequestException
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import com.mercadopago.MercadoPagoConfig
import com.mercadopago.client.payment.PaymentClient
import com.mercadopago.client.payment.PaymentCreateRequest
import com.mercadopago.client.payment.PaymentPayerRequest
import com.mercadopago.exceptions.MPApiException
import com.mercadopago.resources.payment.Payment
import org.springframework.stereotype.Component
import java.math.BigDecimal

val MERCADO_PAGO_TOKEN = "TEST-1405158007413614-072110-c1f6e5cfc6c88cb6c282e4eb4a378a31-745903552"
val MERCADO_PAGO_ID = "1182098345-12JIUzreYBylDG"
val MERCADO_PAGO_PAYMENT_METHOD = "pix"

@Component
class MercadoPagoMercadoPagoPaymentDataSource() : IMercadoPagoPaymentDataSource {

    init {
        MercadoPagoConfig.setAccessToken(MERCADO_PAGO_TOKEN)
    }

    private val paymentClient = PaymentClient()

    override fun getPayment(paymentId: Int): Payment {
        try {
            return paymentClient.get(paymentId.toLong())
        } catch (ex: Exception) {
            throw ResourceInternalServerException(message = "Failed integration with Mercado Pago", exception = ex)
        } catch (ex: MPApiException) {
            throw ResourceBadRequestException(message = "Mercado Pago service failure", exception = ex)
        }
    }

    override fun createPayment(amount: BigDecimal): Payment? {
        return try {
            paymentClient.create(
                PaymentCreateRequest.builder()
                    .transactionAmount(amount)
                    .payer(PaymentPayerRequest.builder().id(MERCADO_PAGO_ID).build())
                    .paymentMethodId(MERCADO_PAGO_PAYMENT_METHOD)
                    .notificationUrl("http://challenge.group20.com/v1/payment/webhook")
                    .build()
            )
        } catch (ex: Exception) {
            null
        } catch (ex: MPApiException) {
            null
        }
    }
}