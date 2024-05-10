package br.group.twenty.challenge.application.adapters

import br.group.twenty.challenge.domain.models.Product

interface FindProduct {
    fun findProductById(id: Int): Product?
}