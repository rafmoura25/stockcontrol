package com.br.stockadm.controller

import com.br.stockadm.model.Color
import com.br.stockadm.service.ColorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ColorController(private val colorService: ColorService){

    @GetMapping("/colors")
    fun getAllColors(): List<Color> = colorService.getAll();

    @PostMapping("/colors")
    fun createNewColor(@Valid @RequestBody color: Color): ResponseEntity<Color>{
        colorService.save(color)
        return ResponseEntity.ok(color)
    }

    @GetMapping("/colors/{id}")
    fun getColorById(@PathVariable(value = "id") id: Long): ResponseEntity<Color>{
        return ResponseEntity.ok(colorService.getById(id))
    }

    @PutMapping("/colors/{id}")
    fun updateColor(@PathVariable("id") id: Long, @Valid @RequestBody color: Color) : ResponseEntity<Color>{
        if(colorService.existsById(id))
            return ResponseEntity.ok(colorService.update(id, color))

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/colors/{id}")
    fun deleteColorById(@PathVariable(value = "id") id: Long): ResponseEntity<Unit>{
        if(colorService.existsById(id))
            return ResponseEntity.ok(colorService.delete(id))

        return ResponseEntity.notFound().build()
    }
}