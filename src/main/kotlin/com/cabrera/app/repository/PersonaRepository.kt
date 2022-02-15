package com.cabrera.app.repository

import com.cabrera.app.model.Personas
import org.springframework.data.jpa.repository.JpaRepository

interface PersonaRepository:JpaRepository<Personas, Long> {
    fun findById(id: Long?): Personas?
}