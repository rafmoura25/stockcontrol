package com.br.stockadm.service

import com.br.stockadm.model.Product
import com.br.stockadm.repository.ProductRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ProductServiceImpl(private val productRepository: ProductRepository) : ProductService {
    override fun getAll(): List<Product> = productRepository.findAll().toList()

    override fun getById(id: Long): Product = productRepository.findById(id).orElseThrow{ EntityNotFoundException() }

    override fun save(product: Product): Product = productRepository.save(product)

    override fun existsById(id: Long): Boolean = productRepository.existsById(id)

    override fun update(id: Long, product: Product): Product = save(product.copy(id = id))

    override fun delete(id: Long) = productRepository.deleteById(id)

}