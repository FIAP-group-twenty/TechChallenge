package br.group.twenty.challenge.api.configs

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/is-alive")
class IsAlive {
    @GetMapping
    fun isAlive(): Boolean = true
}
