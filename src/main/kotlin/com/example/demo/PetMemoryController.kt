package com.example.demo.controller

import com.example.demo.model.Pet
import com.example.demo.service.PetServiceMemory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pets-memory")
class PetMemoryController(private val petServiceMemory: PetServiceMemory) {

    @GetMapping
    fun listarTudo(): ResponseEntity<List<Pet>> =
        ResponseEntity.ok(petServiceMemory.listarTudo())

    @PostMapping
    fun criar(@RequestBody pet: Pet): ResponseEntity<String> {
        petServiceMemory.cadastrar(pet)
        return ResponseEntity("Criado com sucesso", HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable id: Long): ResponseEntity<String> =
        if (!petServiceMemory.apagar(id)) {
            ResponseEntity("ID inexistente", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Removido com sucesso", HttpStatus.OK)
        }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody pet: Pet): ResponseEntity<String> =
        if (!petServiceMemory.atualizar(id, pet)) {
            ResponseEntity("ID inexistente", HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity("Atualizado com sucesso", HttpStatus.OK)
        }
}
