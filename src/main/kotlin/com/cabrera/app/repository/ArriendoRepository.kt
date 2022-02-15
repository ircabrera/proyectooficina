package com.cabrera.app.repository

import com.cabrera.app.model.Arriendos
import org.springframework.data.jpa.repository.JpaRepository

interface ArriendoRepository:JpaRepository<Arriendos, Long> {
    fun findById(id: Long?): Arriendos?
}