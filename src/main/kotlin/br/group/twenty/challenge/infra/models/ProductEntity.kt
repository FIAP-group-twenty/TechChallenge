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
    var name: String? = null,
    var price: Double? = null,
    var description: String? = null,
    @Enumerated(value = STRING)
    var category: CategoryEnum? = null
) {
    init {
        validProductFields()
    }

    private fun validProductFields() {
        if (name.isNullOrBlank()) throw Exception("Name cannot be empty or null")
        if (price == null || price == 0.0) throw Exception("Price cannot be 0 or null")
        if (description.isNullOrBlank()) throw Exception("Description cannot be empty or null")
        if (category == null) throw Exception("Category cannot be null")
    }

}
