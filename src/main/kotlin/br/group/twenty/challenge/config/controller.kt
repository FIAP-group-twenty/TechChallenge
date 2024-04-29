package br.group.twenty.challenge.config

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/apiv1/is-alive")
class IsAlive {
    @GetMapping
    fun isAlive(): Boolean = true
}
