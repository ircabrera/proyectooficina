package com.cabrera.app.controllers

import com.cabrera.app.model.Oficinas
import com.cabrera.app.model.Personas
import com.cabrera.app.service.OficinaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/oficina")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class OficinaController {

    @Autowired
    lateinit var oficinaService: OficinaService

    @GetMapping
    fun list(): List<Oficinas>{
        return oficinaService.list()
    }

    @PostMapping
    fun save (@RequestBody oficinas: Oficinas): Oficinas {
        return oficinaService.save(oficinas)
    }

    @PutMapping
    fun update (@RequestBody oficinas: Oficinas): Oficinas {
        return oficinaService.update(oficinas)
    }

    @PatchMapping
    fun patch(@RequestBody oficinas: Oficinas): Oficinas {
        return oficinaService.patch(oficinas)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return oficinaService.delete(id)
    }
}
