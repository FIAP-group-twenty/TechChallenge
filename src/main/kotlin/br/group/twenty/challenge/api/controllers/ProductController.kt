package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.usecases.FindProductUseCase
import br.group.twenty.challenge.application.usecases.UpdateProductUseCase
import br.group.twenty.challenge.domain.models.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val findProductUseCase: FindProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase
) {

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<Any> {
        val product = findProductUseCase.findProductById(id)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for ID: $id")
        }
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updatedProduct: Product): ResponseEntity<Any> {
        val product = updateProductUseCase.updateProduct(id, updatedProduct)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for ID: $id")
        }
    }

}
