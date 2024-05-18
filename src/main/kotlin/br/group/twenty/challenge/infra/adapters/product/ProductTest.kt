package br.group.twenty.challenge.infra.adapters.product

import br.group.twenty.challenge.domain.models.Product
import br.group.twenty.challenge.domain.ports.ProductPort
import br.group.twenty.challenge.infra.adapters.CreateProductAdapter
import br.group.twenty.challenge.infra.adapters.DeleteProductAdapter
import br.group.twenty.challenge.infra.adapters.FindProductAdapter
import br.group.twenty.challenge.infra.adapters.UpdateProductAdapter
import br.group.twenty.challenge.infra.models.ProductEntity
import br.group.twenty.challenge.infra.repositories.ProductJpaRepository
import org.springframework.stereotype.Repository

@Repository
class ProductTest(
    final val repository: ProductJpaRepository
) : ProductPort {
    val create = CreateProductAdapter(repository)
    val find = FindProductAdapter(repository)
    val delete = DeleteProductAdapter(repository)
    val update = UpdateProductAdapter(repository)

    override fun createProduct(product: Product): ProductEntity {
       return create.createProduct(product)
    }

    override fun findProductById(id: Int): ProductEntity? {
        return find.findProductById(id)
    }

    override fun updateProduct(id: Int, product: Product): ProductEntity? {
        return update.updateProduct(id, product)
    }

    override fun deleteProduct(id: Int): ProductEntity? {
        return delete.deleteProduct(id)
    }
}