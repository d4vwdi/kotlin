package com.example.demo.model

import jakarta.persistence.*

@Entity
data class Tutor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nome: String,
    val documento: String
)
