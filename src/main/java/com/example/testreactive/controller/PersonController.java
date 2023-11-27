package com.example.testreactive.controller;

import com.example.testreactive.dto.PersonDto;
import com.example.testreactive.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/fast")
    public Flux<PersonDto> getFromFastClient() {
        return personService.getFastRandomPersons();
    }

    @GetMapping("/slow")
    public Flux<PersonDto> getFromSlowClient() {
        return personService.getSlowRandomPersons();
    }

    @GetMapping("/random")
    public Flux<PersonDto> getRandomPerson() {
        return personService.getRandomPersons();
    }
}
