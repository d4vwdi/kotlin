package com.example.demo.model
import java.time.LocalDate

data class PetDTO(
    val id: Long,
    val nome: String,
    val raca: String,
    val peso: Float,
    val nascimento: LocalDate,
    val tutorId: Long
)
