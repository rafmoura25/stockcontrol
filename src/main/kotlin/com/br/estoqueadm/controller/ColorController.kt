package com.br.estoqueadm.controller

import com.br.estoqueadm.model.Color
import com.br.estoqueadm.repository.ColorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ColorController(private val colorRepository: ColorRepository){

    @GetMapping("/colors")
    fun getAllColors(): List<Color> =
            colorRepository.findAll();

    @PostMapping("/colors")
    fun createNewColor(@Valid @RequestBody color: Color): ResponseEntity<Color>{
        colorRepository.save(color)
        return ResponseEntity.ok(color)
    }

    @GetMapping("colors/{id}")
    fun getColorById(@PathVariable(value = "id") colorId: Long): ResponseEntity<Color>{
        return colorRepository.findById(colorId).map { color ->
            ResponseEntity.ok(color)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun deleteColorById(@PathVariable(value = "id") colorId: Long): ResponseEntity<Void>{
        return colorRepository.findById(colorId).map { color ->
            colorRepository.delete(color)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}