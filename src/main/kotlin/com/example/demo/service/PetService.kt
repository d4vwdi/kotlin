    package com.example.demo.service
    
    import com.example.demo.model.Pet
    import com.example.demo.model.PetDTO
    import com.example.demo.model.Tutor
    import com.example.demo.repository.PetRepository
    import com.example.demo.repository.TutorRepository
    import org.springframework.stereotype.Service
    import java.util.*
    
    @Service
    class PetService(
        private val petRepository: PetRepository,
        private val tutorRepository: TutorRepository
    ) {
        fun getAllPets(): List<PetDTO> = petRepository.findAll().map { pet ->
            PetDTO(pet.id, pet.nome, pet.raca, pet.peso, pet.nascimento, pet.tutor.id)
        }
    
        fun getPetById(id: Long): Optional<PetDTO> = petRepository.findById(id).map { pet ->
            PetDTO(pet.id, pet.nome, pet.raca, pet.peso, pet.nascimento, pet.tutor.id)
        }
    
        fun createPet(petDTO: PetDTO): PetDTO {
            val tutor = tutorRepository.findById(petDTO.tutorId).orElseThrow { IllegalArgumentException("Tutor não encontrado") }
            val pet = Pet(0, petDTO.nome, petDTO.raca, petDTO.peso, petDTO.nascimento, tutor)
            val savedPet = petRepository.save(pet)
            return PetDTO(savedPet.id, savedPet.nome, savedPet.raca, savedPet.peso, savedPet.nascimento, savedPet.tutor.id)
        }
    
        fun deletePet(id: Long) = petRepository.deleteById(id)
    }
