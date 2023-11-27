package com.example.testreactive.controller

import com.example.testreactive.dto.PersonDto
import com.example.testreactive.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class PersonController(private val personService: PersonService) {

    @GetMapping("/fast")
    suspend fun getFromFastClient(): List<PersonDto> = personService.getFastRandomPersons()

    @GetMapping("/slow")
    suspend fun getFromSlowClient(): List<PersonDto> = personService.getSlowRandomPersons()

    @GetMapping("/random")
    suspend fun getRandomPerson(): List<PersonDto> = personService.getRandomPersons()
}
