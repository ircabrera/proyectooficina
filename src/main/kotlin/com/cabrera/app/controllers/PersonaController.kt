package com.cabrera.app.controllers

import com.cabrera.app.model.Personas
import com.cabrera.app.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/persona")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class PersonaController {

    @Autowired
    lateinit var personaService: PersonaService

    @GetMapping
    fun list(): List<Personas>{
        return personaService.list()
    }

    @PostMapping
    fun save (@RequestBody personas: Personas):Personas{
        return personaService.save(personas)
    }

    @PutMapping
    fun update (@RequestBody personas: Personas):Personas{
        return personaService.update(personas)
    }

    @PatchMapping
    fun patch(@RequestBody personas: Personas):Personas{
        return personaService.patch(personas)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return personaService.delete(id)
    }

}
