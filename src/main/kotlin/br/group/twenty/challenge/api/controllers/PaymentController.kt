package br.group.twenty.challenge.api.controllers;

import br.group.twenty.challenge.api.presenters.PaymentPresenter
import br.group.twenty.challenge.core.entities.mapper.OrderMapper.toUpdateOrderRequest
import br.group.twenty.challenge.core.entities.payment.Notification
import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.usecases.order.UpdateOrderUseCase
import br.group.twenty.challenge.core.usecases.payment.GetPaymentStatusUseCase
import br.group.twenty.challenge.core.usecases.payment.UpdatePaymentUseCase
import com.google.gson.Gson
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/payment")
@RestController
class PaymentController(
    private val paymentStatusUseCase: GetPaymentStatusUseCase,
    private val updatePaymentUseCase: UpdatePaymentUseCase,
    private val updateOrderUseCase: UpdateOrderUseCase
) {

    @PutMapping("/webhook")
    fun paymentWebhook(@RequestBody notificationJson: String): ResponseEntity<Void> {
        val notification = Gson().fromJson(notificationJson, Notification::class.java)

        val payment = updatePaymentUseCase.execute(notification.data.id.toInt())

        if (payment != null) {
            updateOrderUseCase.execute(payment.order!!.idOrder!!, toUpdateOrderRequest(payment.status!!))
        }

        return ResponseEntity.ok().build()
    }

    @GetMapping("/status")
    fun paymentStatus(@PathVariable orderId: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(PaymentPresenter.formatterPayment(paymentStatusUseCase.execute(orderId)))
    }
}
