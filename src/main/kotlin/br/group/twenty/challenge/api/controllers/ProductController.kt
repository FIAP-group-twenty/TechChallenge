package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.application.adapters.product.create.CreateProduct
import br.group.twenty.challenge.application.adapters.product.delete.DeleteProduct
import br.group.twenty.challenge.application.adapters.product.find.FindProduct
import br.group.twenty.challenge.application.port.output.product.UpdateProductOutputPort
import br.group.twenty.challenge.domain.models.product.Product
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val createProduct: CreateProduct,
    private val findProduct: FindProduct,
    private val updateProduct: UpdateProductOutputPort,
    private val deleteProduct: DeleteProduct,
) {

    @PostMapping
    fun createProduct(@RequestBody productRequest: Product): ResponseEntity<Any> =
        ResponseEntity.status(CREATED).body(createProduct.createProduct(productRequest))

    @GetMapping("/{category}")
    fun getProductByCategory(@PathVariable category: String): ResponseEntity<List<Any>> {
        return ResponseEntity.ok(findProduct.findProductByCategory(category))
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updatedProduct: Product): ResponseEntity<Any> {
        return ResponseEntity.ok(updateProduct.updateProduct(id, updatedProduct))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok().body(deleteProduct.deleteProduct(id))
    }

}
