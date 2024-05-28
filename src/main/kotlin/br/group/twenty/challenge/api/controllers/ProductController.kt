package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.adapters.product.create.CreateProduct
import br.group.twenty.challenge.application.adapters.product.delete.DeleteProduct
import br.group.twenty.challenge.application.adapters.product.find.FindProduct
import br.group.twenty.challenge.application.port.output.product.UpdateProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product
import org.springframework.http.HttpStatus.CREATED
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
    private val createProduct: CreateProduct,
    private val findProduct: FindProduct,
    private val updateProduct: UpdateProductOutputPort,
    private val deleteProduct: DeleteProduct,
) {

    @PostMapping
    fun createProduct(@RequestBody createRequest: Product): ResponseEntity<Any> =
        ResponseEntity.status(CREATED).body(createProduct.createProduct(createRequest))

    @GetMapping("/{category}")
    fun getProductByCategory(@PathVariable category: String): ResponseEntity<List<Any>> {
        return ResponseEntity.ok(findProduct.findProductByCategory(category))
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updateRequest: Product): ResponseEntity<Any> {
        return ResponseEntity.ok(updateProduct.updateProduct(id, updateRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok().body(deleteProduct.deleteProduct(id))
    }

}
