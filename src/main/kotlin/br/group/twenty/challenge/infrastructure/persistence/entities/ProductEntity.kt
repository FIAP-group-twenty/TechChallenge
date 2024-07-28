package br.group.twenty.challenge.infrastructure.persistence.entities

import br.group.twenty.challenge.infrastructure.exceptions.ResourceBadRequestException
import jakarta.persistence.Entity
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
    var name: String?,
    var price: Double?,
    var description: String?,
    var category: String?
) {
    init {
        validProductFields()
    }

    private fun validProductFields() {
        if (name.isNullOrBlank()) throw ResourceBadRequestException("Name cannot be empty")
        if (category.isNullOrBlank()) throw ResourceBadRequestException("Category cannot be empty")
        if (description.isNullOrBlank()) throw ResourceBadRequestException("Description cannot be empty")
        if (price?.equals(null) == true) throw ResourceBadRequestException("Price cannot be null")
        if (price?.equals(0.0) == true) throw ResourceBadRequestException("Price cannot be 0")
    }

}
