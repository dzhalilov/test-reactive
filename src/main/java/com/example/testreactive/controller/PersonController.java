package com.example.testreactive.controller;

import com.example.testreactive.dto.PersonDto;
import com.example.testreactive.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/fast")
    public List<PersonDto> getFromFastClient() {
        return personService.getFastRandomPersons();
    }

    @GetMapping("/slow")
    public List<PersonDto> getFromSlowClient() {
        return personService.getSlowRandomPersons();
    }

    @GetMapping("/random")
    public List<PersonDto> getRandomPerson() {
        return personService.getRandomPersons();
    }
}
