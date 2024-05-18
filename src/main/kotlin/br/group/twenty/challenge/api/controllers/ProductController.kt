package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.usecases.CreateProductUseCase
import br.group.twenty.challenge.application.usecases.DeleteProductUseCase
import br.group.twenty.challenge.application.usecases.FindProductUseCase
import br.group.twenty.challenge.application.usecases.UpdateProductUseCase
import br.group.twenty.challenge.domain.models.Product
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val findProductUseCase: FindProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
) {

    @PostMapping
    fun creaeProduct(@RequestBody productRequest: Product): ResponseEntity<Any> =
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
