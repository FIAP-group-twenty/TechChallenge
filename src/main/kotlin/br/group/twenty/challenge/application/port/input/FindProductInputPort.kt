package br.group.twenty.challenge.application.port.input

import br.group.twenty.challenge.domain.models.Product

interface FindProductInputPort {
    fun findProductById(id: Int): Product?
}