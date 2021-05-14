package com.br.stockadm.controller

import com.br.stockadm.model.Product
import com.br.stockadm.service.ColorService
import com.br.stockadm.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProductController(private val productService: ProductService,
                        private val colorService: ColorService){

    @GetMapping("/products")
    fun getAllProducts(): List<Product> = productService.getAll()

    @PostMapping("/products")
    fun createNewProduct(@Valid @RequestBody product: Product){
        product.color?.let { colorService.save(it) }
        productService.save(product)
    }

    @GetMapping("/products/{id}")
    fun getProductById(@PathVariable(value = "id") id: Long): ResponseEntity<Product>{
        return ResponseEntity.ok(productService.getById(id))
    }

    @PutMapping("/products/{id}")
    fun updateProduct(@PathVariable("id") id: Long, @Valid @RequestBody product: Product) : ResponseEntity<Product>{
        if(productService.existsById(id))
            return ResponseEntity.ok(productService.update(id, product))

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/products/{id}")
    fun deleteProductById(@PathVariable(value = "id") id: Long): ResponseEntity<Unit>{
        if(productService.existsById(id))
            return ResponseEntity.ok(productService.delete(id))

        return ResponseEntity.notFound().build()
    }
}