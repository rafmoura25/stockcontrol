package com.br.estoqueadm.repository

import com.br.estoqueadm.model.Color
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ColorRepository : JpaRepository<Color, Long>