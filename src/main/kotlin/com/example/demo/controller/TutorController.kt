package com.example.demo.controller

import com.example.demo.model.Tutor
import com.example.demo.service.TutorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tutores")
class TutorController(private val tutorService: TutorService) {

    @GetMapping
    fun listarTudo(): ResponseEntity<List<Tutor>> =
        ResponseEntity.ok(tutorService.listarTudo())

    @PostMapping
    fun criar(@RequestBody tutor: Tutor): ResponseEntity<String> {
        tutorService.cadastrar(tutor)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable id: Long): ResponseEntity<String> =
        if (!tutorService.apagar(id)) {
            ResponseEntity("ID inexistente", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Removido com sucesso", HttpStatus.OK)
        }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody tutor: Tutor): ResponseEntity<String> =
        if (!tutorService.atualizar(id, tutor)) {
            ResponseEntity("ID inexistente", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Atualizado com sucesso", HttpStatus.OK)
        }
}
