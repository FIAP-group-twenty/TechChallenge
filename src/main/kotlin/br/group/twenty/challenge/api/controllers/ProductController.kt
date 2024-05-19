package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.adapters.product.CreateProduct
import br.group.twenty.challenge.application.adapters.product.DeleteProduct
import br.group.twenty.challenge.application.adapters.product.FindProduct
import br.group.twenty.challenge.application.port.output.product.UpdateProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val createProductUseCase: CreateProduct,
    private val findProductUseCase: FindProduct,
    private val updateProductUseCase: UpdateProductOutputPort,
    private val deleteProductUseCase: DeleteProduct,
) {

    @PostMapping
    fun createProduct(@RequestBody productRequest: Product): ResponseEntity<Any> =
        ResponseEntity.status(CREATED).body(createProductUseCase.createProduct(productRequest))

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Any> {
        val product = findProductUseCase.findProductById(id)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.status(NOT_FOUND).body("Product not found for ID: $id")
        }
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updatedProduct: Product): ResponseEntity<Any> {
        val product = updateProductUseCase.updateProduct(id, updatedProduct)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.status(NOT_FOUND).body("Product not found for ID: $id")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Any> {
        val product = findProductUseCase.findProductById(id)
        return if (product != null) {
            ResponseEntity.ok().body(deleteProductUseCase.deleteProduct(id))
        } else {
            ResponseEntity.status(NOT_FOUND).body("Product not found for ID: $id")
        }
    }

}
