package br.group.twenty.challenge.application.port.output

import br.group.twenty.challenge.infra.models.ProductEntity

interface FindProductOutputPort {
    fun findProductById(id: Int): ProductEntity?
}