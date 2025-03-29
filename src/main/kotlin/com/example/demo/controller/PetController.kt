package com.example.demo.controller

import com.example.demo.model.PetDTO
import com.example.demo.service.PetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pets")
class PetController(private val petService: PetService) {
    @GetMapping
    fun getAllPets(): List<PetDTO> = petService.getAllPets()

    @GetMapping("/{id}")
    fun getPetById(@PathVariable id: Long): ResponseEntity<PetDTO> = petService.getPetById(id)
        .map { ResponseEntity.ok(it) }
        .orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun createPet(@RequestBody petDTO: PetDTO): PetDTO = petService.createPet(petDTO)

    @DeleteMapping("/{id}")
    fun deletePet(@PathVariable id: Long) = petService.deletePet(id)
}
