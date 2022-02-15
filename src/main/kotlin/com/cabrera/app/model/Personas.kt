package com.cabrera.app.model

import javax.persistence.*

@Entity
@Table(name = "persona")

class Personas{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var apellido: String? = null
    var cedula: String? = null
    var celular: String? = null
}