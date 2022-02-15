package com.cabrera.app.model

import javax.persistence.*

@Entity
@Table(name = "oficina")

class Oficinas{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var codigo: String? = null
    var direccion: String? = null
}