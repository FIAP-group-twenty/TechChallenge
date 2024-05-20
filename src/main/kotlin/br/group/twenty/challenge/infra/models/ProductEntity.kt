package br.group.twenty.challenge.infra.models

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "tb_product")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val idProduct: Int? = null,
    var name: String,
    var price: Double,
    var description: String,
    var category: String
) {
    init {
        validProductFields()
    }

    private fun validProductFields() {
        if (name.isBlank()) throw Exception("Name cannot be empty")
        if (category.isBlank()) throw Exception("Category cannot be empty")
        if (description.isBlank()) throw Exception("Description cannot be empty")
        if (price.equals(0.0)) throw Exception("Price cannot be 0")
    }

}
