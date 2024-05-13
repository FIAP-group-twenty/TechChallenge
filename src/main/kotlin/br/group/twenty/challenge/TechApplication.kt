package br.group.twenty.challenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TechApplication

fun main(args: Array<String>) {
	runApplication<TechApplication>(*args)
}