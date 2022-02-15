package com.cabrera.app.service

import com.cabrera.app.model.Oficinas
import com.cabrera.app.repository.OficinaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OficinaService {
    @Autowired
    lateinit var oficinaRepository: OficinaRepository


    fun list(): List<Oficinas> {

        return oficinaRepository.findAll()
    }


    fun save(oficina: Oficinas): Oficinas {
        return oficinaRepository.save(oficina)
    }


    fun update(oficinas: Oficinas): Oficinas  {
        val response = oficinaRepository.findById(oficinas.id)
                ?: throw Exception()

        response.codigo=oficinas.codigo;
        response.direccion=oficinas.direccion;
        return oficinaRepository.save(oficinas)
    }


    fun patch (oficinas: Oficinas): Oficinas  {
        val response = oficinaRepository.findById(oficinas.id)
                ?: throw Exception()

        response.codigo=oficinas.codigo;
        response.direccion=oficinas.direccion;

        return oficinaRepository.save(oficinas)
    }

    fun delete (id:Long): Boolean{
        oficinaRepository.deleteById(id)
        return true
    }

}