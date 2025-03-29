package com.example.demo.service

import com.example.demo.model.Pet
import org.springframework.stereotype.Service

@Service
class PetServiceMemory {
    private var counter: Long = 0
    private val pets = mutableListOf<Pet>()

    fun cadastrar(pet: Pet): Pet {
        counter++
        val novoPet = pet.copy(id = counter)
        pets.add(novoPet)
        return novoPet
    }

    fun listarTudo(): List<Pet> = pets

    fun findById(id: Long): Pet? = pets.find { it.id == id }

    fun apagar(id: Long): Boolean {
        val pet = findById(id)
        return if (pet != null) {
            pets.remove(pet)
            true
        } else {
            false
        }
    }

    fun atualizar(id: Long, novaEntidade: Pet): Boolean {
        val index = pets.indexOfFirst { it.id == id }
        return if (index != -1) {
            pets[index] = novaEntidade.copy(id = id)
            true
        } else {
            false
        }
    }
}
