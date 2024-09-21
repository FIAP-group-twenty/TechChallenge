package br.group.twenty.challenge.infrastructure.gateways.payment

import br.group.twenty.challenge.core.gateways.IPaymentPartnerGateway
import br.group.twenty.challenge.infrastructure.api.client.IPaymentPartnerDataSource
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import com.mercadopago.resources.payment.Payment
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class MercadoPagoPaymentGateway(
    private val dataSource: IPaymentPartnerDataSource
) : IPaymentPartnerGateway {

    override fun getPayment(paymentId: Int): Payment {
        try {
            return dataSource.getPayment(paymentId)
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