package com.example.demo.service

import com.example.demo.model.Tutor
import org.springframework.stereotype.Service

@Service
class TutorService {
    private var counter: Long = 0
    private val tutors = mutableListOf<Tutor>()

    fun cadastrar(tutor: Tutor): Tutor {
        counter++
        val novoTutor = tutor.copy(id = counter)
        tutors.add(novoTutor)
        return novoTutor
    }

    fun listarTudo(): List<Tutor> = tutors

    fun findById(id: Long): Tutor? = tutors.find { it.id == id }

    fun apagar(id: Long): Boolean {
        val tutor = findById(id)
        return if (tutor != null) {
            tutors.remove(tutor)
            true
        } else {
            false
        }
    }

    fun atualizar(id: Long, novaEntidade: Tutor): Boolean {
        val index = tutors.indexOfFirst { it.id == id }
        return if (index != -1) {
            tutors[index] = novaEntidade.copy(id = id)
            true
        } else {
            false
        }
    }
}
