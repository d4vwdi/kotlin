package com.example.demo.mapper

import com.example.demo.model.Pet
import com.example.demo.model.PetDTO
import com.example.demo.model.Tutor
import com.example.demo.service.TutorService
import org.springframework.stereotype.Component

@Component
class PetMapper(private val tutorService: TutorService) {

    fun toDTO(pet: Pet): PetDTO {
        return PetDTO(
            id = pet.id,
            nome = pet.nome,
            raca = pet.raca,
            peso = pet.peso,
            nascimento = pet.nascimento,
            tutorId = pet.tutor.id
        )
    }

    fun fromDTO(petDTO: PetDTO): Pet {
        val tutor: Tutor = tutorService.findById(petDTO.tutorId)
            ?: throw IllegalArgumentException("Tutor não encontrado para o id ${petDTO.tutorId}")
        return Pet(
            id = petDTO.id,
            nome = petDTO.nome,
            raca = petDTO.raca,
            peso = petDTO.peso,
            nascimento = petDTO.nascimento,
            tutor = tutor
        )
    }
}
