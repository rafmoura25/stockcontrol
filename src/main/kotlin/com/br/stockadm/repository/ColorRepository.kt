package com.br.stockadm.repository

import com.br.stockadm.model.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Repository

@Repository
@EnableJpaRepositories
interface ColorRepository : JpaRepository<Color, Long>