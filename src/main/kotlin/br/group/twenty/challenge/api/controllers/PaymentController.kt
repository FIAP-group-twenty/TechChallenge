package br.group.twenty.challenge.api.controllers;

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1/payment")
@RestController
class PaymentController(
) {

    @PutMapping("/approved")
    fun payApproved() {}

    @PutMapping("/denied")
    fun payDenied() {}

    //todo: implementar endpoints
}
