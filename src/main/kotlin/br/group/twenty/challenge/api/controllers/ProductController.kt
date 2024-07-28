package br.group.twenty.challenge.api.controllers

import br.group.twenty.challenge.api.presenters.ProductPresenter
import br.group.twenty.challenge.core.entities.product.Product
import br.group.twenty.challenge.core.usecases.product.CreateProductUseCase
import br.group.twenty.challenge.core.usecases.product.DeleteProductUseCase
import br.group.twenty.challenge.core.usecases.product.GetProductByCategoryUseCase
import br.group.twenty.challenge.core.usecases.product.UpdateProductUseCase
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase,
    private val getProductByCategoryUseCase: GetProductByCategoryUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) {

    @PostMapping
    fun createProduct(@RequestBody productRequest: Product): ResponseEntity<Any> =
        ResponseEntity.status(CREATED)
            .body(ProductPresenter.formatterProduct(createProductUseCase.execute(productRequest)))

    @GetMapping("/{category}")
    fun getProductByCategory(@PathVariable category: String): ResponseEntity<List<Any>> {
        return ResponseEntity.ok(ProductPresenter.formatterProductList(getProductByCategoryUseCase.execute(category)))
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Int, @RequestBody updatedProduct: Product): ResponseEntity<Any> {
        return ResponseEntity.ok(ProductPresenter.formatterProduct(updateProductUseCase.execute(id, updatedProduct)))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<Any> {
        return ResponseEntity.ok().body(ProductPresenter.formatterProduct(deleteProductUseCase.execute(id)))
    }

}
