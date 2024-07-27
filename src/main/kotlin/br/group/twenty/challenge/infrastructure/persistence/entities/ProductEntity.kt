package br.group.twenty.challenge.infrastructure.persistence.entities

import br.group.twenty.challenge.core.exceptions.ResourceBusinessException
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "tb_product")
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val idProduct: Int? = null,
    var name: String?,
    var price: Double?,
    var description: String?,
    var category: String?
) {
    init {
        validProductFields()
    }

    private fun validProductFields() {
        if (name.isNullOrBlank()) throw ResourceBusinessException("Name cannot be empty")
        if (category.isNullOrBlank()) throw ResourceBusinessException("Category cannot be empty")
        if (description.isNullOrBlank()) throw ResourceBusinessException("Description cannot be empty")
        if (price?.equals(null) == true) throw ResourceBusinessException("Price cannot be null")
        if (price?.equals(0.0) == true) throw ResourceBusinessException("Price cannot be 0")
    }

}
