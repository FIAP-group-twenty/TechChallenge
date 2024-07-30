package br.group.twenty.challenge.api.controllers;

import br.group.twenty.challenge.api.presenters.PaymentPresenter
import br.group.twenty.challenge.core.entities.payment.Payment
import br.group.twenty.challenge.core.usecases.payment.GetPaymentStatusUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/payment")
@RestController
class PaymentController(
    private val paymentStatusUseCase: GetPaymentStatusUseCase
) {

    @PutMapping("/webhook")
    fun paymentWebhook() {

    }

    @GetMapping("/status/{orderId}")
    fun paymentStatus(@PathVariable orderId: Int): ResponseEntity<Payment> {
        return ResponseEntity.ok(PaymentPresenter.formatterPayment(paymentStatusUseCase.execute(orderId)))
    }
}
