package br.group.twenty.challenge.infra.models

import jakarta.persistence.*

@Entity
@Table(name = "tb_product")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idProduct: Int? = null,
    var name: String,
    var category: String,
    var price: Double,
    var description: String
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
