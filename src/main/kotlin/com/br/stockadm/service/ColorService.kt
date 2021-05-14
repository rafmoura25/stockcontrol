package com.br.stockadm.service

import com.br.stockadm.model.Color
import org.springframework.stereotype.Service

@Service
interface ColorService {
    fun getAll(): List<Color>
    fun getById(id: Long): Color
    fun save(color: Color): Color
    fun existsById(id: Long): Boolean
    fun update(id: Long, color: Color): Color
    fun delete(id: Long)
}