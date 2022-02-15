package com.cabrera.app.repository

import com.cabrera.app.model.Oficinas
import com.cabrera.app.model.Personas
import org.springframework.data.jpa.repository.JpaRepository

interface OficinaRepository:JpaRepository<Oficinas, Long> {
    fun findById(id: Long?): Oficinas?
}