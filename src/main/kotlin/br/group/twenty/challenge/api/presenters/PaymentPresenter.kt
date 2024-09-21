package br.group.twenty.challenge.api.presenters

import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.entities.payment.PaymentStatus
import br.group.twenty.challenge.infrastructure.api.entities.PaymentInformation

object PaymentPresenter {

    fun formatterPayment(paymentInformation: PaymentInformation): Payment =
        Payment(
            idPay = paymentInformation.payment.id.toInt(),
            order = paymentInformation.order,
            qrCode = paymentInformation.payment.pointOfInteraction?.transactionData?.qrCode,
            status = getStatus(paymentInformation.payment.status),
            payValue = paymentInformation.order.orderValue,
            creationOrder = paymentInformation.order.creationOrder,
            lastUpdateOrder = paymentInformation.order.lastUpdateOrder
        )


    private fun getStatus(status: String): String = when (status) {
        "approved" -> PaymentStatus.APPROVED.name
        "rejected" -> PaymentStatus.DENIED.name
        else -> PaymentStatus.PENDING.name
    }
}