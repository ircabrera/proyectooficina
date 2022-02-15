package com.cabrera.app.service

import com.cabrera.app.model.Personas
import com.cabrera.app.repository.ArriendoRepository
import com.cabrera.app.repository.OficinaRepository
import com.cabrera.app.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PersonaService {
    @Autowired
    lateinit var personaRepository: PersonaRepository


    fun list(): List<Personas> {

        return personaRepository.findAll()
    }


    fun save(personas: Personas):Personas{

        return personaRepository.save(personas)
    }


    fun update(personas: Personas):Personas{
        val response = personaRepository.findById(personas.id)
                ?: throw Exception()
        response.nombre= personas.nombre;
        response.apellido=personas.apellido;
        response.cedula=personas.cedula;
        response.celular=personas.celular;

        return personaRepository.save(personas)
    }


    fun patch (personas: Personas):Personas {
        val response = personaRepository.findById(personas.id)
                ?: throw Exception()
        response.nombre= personas.nombre;
        response.apellido=personas.apellido;
        response.cedula=personas.cedula;
        response.celular=personas.celular;


        return personaRepository.save(response)
    }

    fun delete (id:Long): Boolean{
        personaRepository.deleteById(id)
        return true
    }



}