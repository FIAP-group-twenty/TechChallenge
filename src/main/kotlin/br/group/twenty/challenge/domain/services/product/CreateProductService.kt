package br.group.twenty.challenge.domain.services.product

import br.group.twenty.challenge.application.port.input.product.CreateProductInputPort
import br.group.twenty.challenge.application.port.output.product.CreateProductOutputPort
import br.group.twenty.challenge.domain.models.enum.CategoryEnum
import br.group.twenty.challenge.domain.models.mapper.ProductMapper
import br.group.twenty.challenge.domain.models.product.Product
import java.util.Locale

class CreateProductService(
    private val repository: CreateProductOutputPort
) : CreateProductInputPort {

    override fun createProduct(productRequest: Product): Product {
        try {
            val categoryList = CategoryEnum.entries.joinToString(",") { it.name }

            if (categoryList.contains(productRequest.category.uppercase(Locale.getDefault())).not())
                throw Exception("Category is invalid")

            repository.createProduct(productRequest).apply {
                return ProductMapper.toDTO(this)
            }
        } catch (ex: Exception) {
            throw Exception(ex)
        }
    }
}