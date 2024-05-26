package br.group.twenty.challenge.infra.models

import br.group.twenty.challenge.domain.models.enum.CategoryEnum
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.STRING
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_product")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val idProduct: Int? = null,
    var name: String,
    var price: Double,
    var description: String,
    @Enumerated(value = STRING)
    var category: CategoryEnum
) {
    init {
        validProductFields()
    }

    private fun validProductFields() {
        if (name.isBlank()) throw Exception("Name cannot be empty")
        if (description.isBlank()) throw Exception("Description cannot be empty")
        if (price.equals(0.0)) throw Exception("Price cannot be 0")
    }

}
