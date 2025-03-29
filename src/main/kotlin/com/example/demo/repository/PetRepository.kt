package com.example.demo.repository

import com.example.demo.model.Pet
import com.example.demo.model.Tutor
import org.springframework.data.jpa.repository.JpaRepository

interface TutorRepository : JpaRepository<Tutor, Long>

interface PetRepository : JpaRepository<Pet, Long>
