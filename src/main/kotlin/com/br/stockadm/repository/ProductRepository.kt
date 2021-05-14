package com.br.stockadm.repository

import com.br.stockadm.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository

@Repository
@EnableJpaRepositories
interface ProductRepository : JpaRepository<Product, Long>