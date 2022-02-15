package com.cabrera.app.controllers

import com.cabrera.app.model.Arriendos
import com.cabrera.app.model.Oficinas
import com.cabrera.app.model.Personas
import com.cabrera.app.service.ArriendoService
import com.cabrera.app.service.OficinaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/arriendo")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class ArriendoController {

    @Autowired
    lateinit var arriendoService: ArriendoService

    @GetMapping
    fun list(): List<Arriendos>{
        return arriendoService.list()
    }

    @PostMapping
    fun save (@RequestBody arriendos: Arriendos): Arriendos {
        return arriendoService.save(arriendos)
    }

    @PutMapping
    fun update (@RequestBody arriendos: Arriendos): Arriendos {
        return arriendoService.update(arriendos)
    }

    @PatchMapping
    fun patch(@RequestBody arriendos: Arriendos): Arriendos {
        return arriendoService.patch(arriendos)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return arriendoService.delete(id)
    }
}
