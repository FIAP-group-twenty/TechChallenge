package br.group.twenty.challenge.api.controllers;

import br.group.twenty.challenge.api.presenters.PaymentPresenter
import br.group.twenty.challenge.core.entities.payment.Notification
import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.usecases.payment.GetPaymentStatusUseCase
import br.group.twenty.challenge.core.usecases.payment.UpdatePaymentUseCase
import com.google.gson.Gson
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/payment")
@RestController
class PaymentController(
    private val paymentStatusUseCase: GetPaymentStatusUseCase,
    private val updatePaymentUseCase: UpdatePaymentUseCase
) {

    @PutMapping("/webhook")
    fun paymentWebhook(@RequestBody notificationJson: String): ResponseEntity<Void> {
        val notification = Gson().fromJson(notificationJson, Notification::class.java)

        updatePaymentUseCase.execute(notification.data.id.toInt())

        return ResponseEntity.ok().build()
    }

    @GetMapping("/{orderId}")
    fun paymentStatus(@PathVariable orderId: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(PaymentPresenter.formatterPayment(paymentStatusUseCase.execute(orderId)))
    }
}
