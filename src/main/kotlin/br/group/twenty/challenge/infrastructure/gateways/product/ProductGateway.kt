package br.group.twenty.challenge.infrastructure.gateways.product

import br.group.twenty.challenge.core.entities.mapper.ProductMapper.toEntity
import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.core.gateways.IProductGateway
import br.group.twenty.challenge.core.exceptions.ResourceNotFoundException
import br.group.twenty.challenge.infrastructure.persistence.entities.ProductEntity
import br.group.twenty.challenge.infrastructure.persistence.jpa.IProductDataSource
import org.springframework.stereotype.Repository

@Repository
class ProductGateway(private val dataSource: IProductDataSource) : IProductGateway {

    override fun createProduct(product: Product): ProductEntity {
        try {
            return dataSource.save(
                ProductEntity(
                    name = product.name,
                    category = product.category,
                    price = product.price,
                    description = product.description
                )
            )
        } catch (ex: Exception) {
            throw Exception("Failed to create product", ex)
        }
    }

    override fun deleteProduct(product: ProductEntity): ProductEntity {
        try {
            dataSource.delete(product)
            return product
        } catch (ex: Exception) {
            throw Exception("Failed to delete product: ${product.name}", ex)
        }
    }

    override fun findProductById(id: Int): ProductEntity {
        try {
            dataSource.findByIdProduct(id)?.let { product ->
                return product
            }
            throw ResourceNotFoundException("Product not found")
        } catch (ex: Exception) {
            throw Exception("Failed to find product with id: $id", ex)
        }
    }

    override fun findProductByCategory(category: String): List<ProductEntity> {
        try {
            return dataSource.findByCategory(category)
        } catch (ex: Exception) {
            throw Exception("Failed to find product with category: $category", ex)
        }
    }

    override fun updateProduct(oldProduct: ProductEntity, product: Product): ProductEntity {
        try {
            val productUpdate = oldProduct.toEntity(product)
            return dataSource.save(productUpdate)
        } catch (ex: Exception) {
            throw Exception("Failed to update product with ID: ${oldProduct.idProduct}", ex)
        }
    }
}