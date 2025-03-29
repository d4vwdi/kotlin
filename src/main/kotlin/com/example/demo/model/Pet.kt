package com.example.demo.model

import jakarta.validation.Valid
import jakarta.validation.constraints.*
import java.time.LocalDate

data class Pet(
    val id: Long = 0,

    @field:NotBlank(message = "Nome não pode ser vazio")
    @field:Size(min = 5, max = 25, message = "Nome deve ter entre 5 e 25 caracteres")
    val nome: String,

    @field:NotBlank(message = "Raça não pode ser vazia")
    val raca: String,

    @field:DecimalMin(value = "0.0", message = "Peso deve ser maior ou igual a 0.0")
    @field:DecimalMax(value = "400.0", message = "Peso deve ser menor ou igual a 400.0")
    val peso: Double,

    @field:Past(message = "Data de nascimento deve ser no passado")
    val nascimento: LocalDate,

    @field:Valid
    val tutor: Tutor
)
