package com.br.estoqueadm.controller

import com.br.estoqueadm.model.Product
import com.br.estoqueadm.repository.ColorRepository
import com.br.estoqueadm.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProductController(private val productRepository: ProductRepository,
                        private val colorRepository: ColorRepository){

    @GetMapping("/products")
    fun getAllProducts(): List<Product> =
            productRepository.findAll()

    @PostMapping("/products")
    fun createNewProduct(@Valid @RequestBody product: Product){
        product.color?.let { colorRepository.save(it) }
        productRepository.save(product)
    }

    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable(value = "id") productId: Long): ResponseEntity<Product>{
        return productRepository.findById(productId).map { product ->
            ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/products/{id}")
    fun deleteProductById(@PathVariable(value = "id") productId: Long): ResponseEntity<Void>{
        return productRepository.findById(productId).map { product ->
            productRepository.delete(product)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}