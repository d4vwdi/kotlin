package com.example.demo.model
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Pet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nome: String,
    val raca: String,
    val peso: Float,
    val nascimento: LocalDate,
    @ManyToOne @JoinColumn(name = "tutor_id")
    val tutor: Tutor
)
