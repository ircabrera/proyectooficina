package com.cabrera.app.model

import javax.persistence.*

@Entity
@Table(name = "arriendo")

class Arriendos{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var finicio: String? = null
    var ffin: String? = null
    var valor: Long?= null
    var id_persona: Long? = null
    var id_oficina: Long? = null
}