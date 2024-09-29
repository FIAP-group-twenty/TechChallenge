package br.group.twenty.challenge.infrastructure.gateways.product

import br.group.twenty.challenge.core.entities.mapper.ProductMapper.toDto
import br.group.twenty.challenge.core.entities.mapper.ProductMapper.toEntity
import br.group.twenty.challenge.core.entities.mapper.ProductMapper.updateProduct
import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.core.gateways.IProductGateway
import br.group.twenty.challenge.infrastructure.exceptions.ResourceInternalServerException
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.IProductDataSource
import org.springframework.stereotype.Repository

@Repository
class ProductGateway(private val productDataSource: IProductDataSource) : IProductGateway {

    override fun createProduct(product: Product): Product {
        try {
            val result = productDataSource.save(
                ProductEntity(
                    name = product.name,
                    category = product.category,
                    price = product.price,
                    description = product.description
                )
            )
            return result.toDto()
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to create product", ex)
        }
    }

    override fun deleteProduct(product: Product): Product {
        try {
            productDataSource.delete(product.toEntity())
            return product
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to delete product: ${product.name}", ex)
        }
    }

    override fun findProductById(id: Int): Product {
        try {
            productDataSource.findByIdProduct(id)?.let { product ->
                return product.toDto()
            }
            throw ResourceNotFoundException("Product not found")
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find product with id: $id", ex)
        }
    }

    override fun findProductByCategory(category: String): List<Product> {
        try {
            val result = productDataSource.findByCategory(category)
            return result.map { productEntity ->
                productEntity.toDto()
            }
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to find product with category: $category", ex)
        }
    }

    override fun updateProduct(oldProduct: Product, product: Product): Product {
        try {
            val productUpdate = oldProduct.updateProduct(product)
            val result = productDataSource.save(productUpdate)
            return result.toDto()
        } catch (ex: Exception) {
            throw ResourceInternalServerException("Failed to update product with ID: ${oldProduct.name}", ex)
        }
    }
}