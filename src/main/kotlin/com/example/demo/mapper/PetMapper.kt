package com.example.demo.mapper

import com.example.demo.model.Pet
import com.example.demo.model.PetDTO
import com.example.demo.repository.TutorRepository
import jakarta.validation.Validation
import org.springframework.stereotype.Component

@Component
class PetMapper(private val tutorRepository: TutorRepository) {

    fun toDTO(pet: Pet): PetDTO =
        PetDTO(pet.id, pet.nome, pet.raca, pet.peso, pet.nascimento, pet.tutor.id)

    fun fromDTO(petDTO: PetDTO): Pet {
        val tutor = tutorRepository.findById(petDTO.tutorId)
            .orElseThrow { IllegalArgumentException("Tutor não encontrado") }

        val pet = Pet(0, petDTO.nome, petDTO.raca, petDTO.peso, petDTO.nascimento, tutor)

        // Validação manual do objeto Pet
        val validator = Validation.buildDefaultValidatorFactory().validator
        val violations = validator.validate(pet)
        if (violations.isNotEmpty()) {
            throw IllegalArgumentException(violations.joinToString { it.message })
        }

        return pet
    }
}
