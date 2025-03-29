package com.example.demo.model

import jakarta.validation.constraints.*

data class Tutor(
    val id: Long = 0,

    @field:NotBlank(message = "Nome não pode ser vazio")
    @field:Size(min = 5, max = 50, message = "Nome deve ter entre 5 e 50 caracteres")
    val nome: String,

    @field:NotBlank(message = "Documento não pode ser vazio")
    @field:Pattern(
        regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}",
        message = "Documento deve seguir o formato 000.000.000-00"
    )
    val documento: String
)
