package com.cabrera.app.service

import com.cabrera.app.model.Arriendos
import com.cabrera.app.model.Personas
import com.cabrera.app.repository.ArriendoRepository
import com.cabrera.app.repository.OficinaRepository
import com.cabrera.app.repository.PersonaRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ArriendoService {
    @Autowired
    lateinit var arriendoRepository: ArriendoRepository
    @Autowired
    lateinit var oficinaRepository: OficinaRepository
    @Autowired
    lateinit var personaRepository: PersonaRepository


    fun list(): List<Arriendos> {
        return arriendoRepository.findAll()

    }


    fun save(arriendos: Arriendos):Arriendos{
        try{
            personaRepository.findById(arriendos.id_persona) ?: throw Exception("id persona no encontrada")
            oficinaRepository.findById(arriendos.id_oficina) ?: throw Exception("id oficina no encontrada")
           return arriendoRepository.save(arriendos)

        }catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }


    fun update(arriendos: Arriendos): Arriendos {
        val response = arriendoRepository.findById(arriendos.id)
                ?: throw Exception()
        response.finicio = arriendos.finicio;
        response.ffin = arriendos.ffin;
        response.valor = arriendos.valor;
        response.id_persona = arriendos.id_persona;
        response.id_oficina = arriendos.id_oficina;

        try {

            personaRepository.findById(arriendos.id_persona) ?: throw Exception("id persona no encontrada")
            oficinaRepository.findById(arriendos.id_oficina) ?: throw Exception("id oficina no encontrada")
            return arriendoRepository.save(arriendos)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }


    fun patch (arriendos: Arriendos):Arriendos {
        val response = arriendoRepository.findById(arriendos.id)
                ?: throw Exception()
        response.finicio=arriendos.finicio;
        response.ffin=arriendos.ffin;
        response.valor=arriendos.valor;
        response.id_persona=arriendos.id_persona;
        response.id_oficina=arriendos.id_oficina;
        try {

            personaRepository.findById(arriendos.id_persona) ?: throw Exception("id persona no encontrada")
            oficinaRepository.findById(arriendos.id_oficina) ?: throw Exception("id oficina no encontrada")
            return arriendoRepository.save(arriendos)

        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun delete (id:Long): Boolean{
        arriendoRepository.deleteById(id)
        return true
    }



}