package com.br.stockadm.service

import com.br.stockadm.model.Product
import org.springframework.stereotype.Service

@Service
interface ProductService {
    fun getAll(): List<Product>
    fun getById(id: Long): Product
    fun save(product: Product): Product
    fun existsById(id: Long): Boolean
    fun update(id: Long, product: Product): Product
    fun delete(id: Long)
}