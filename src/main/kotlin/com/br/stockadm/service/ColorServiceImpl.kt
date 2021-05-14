package com.br.stockadm.service

import com.br.stockadm.model.Color
import com.br.stockadm.repository.ColorRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ColorServiceImpl(private val colorRepository: ColorRepository) : ColorService {
    override fun getAll(): List<Color> {
        return colorRepository.findAll().toList()
    }

    override fun getById(id: Long): Color {
        return colorRepository.findById(id).orElseThrow{ EntityNotFoundException() }
    }

    override fun save(color: Color): Color {
        return colorRepository.save(color)
    }

    override fun existsById(id: Long): Boolean {
        return colorRepository.existsById(id)
    }

    override fun update(id: Long, color: Color): Color {
        val safeColor = color.copy(id = id)
        return save(safeColor)
    }

    override fun delete(id: Long) {
        return colorRepository.deleteById(id)
    }
}